package sample.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import coil3.ImageLoader
import coil3.compose.LocalPlatformContext
import coil3.compose.setSingletonImageLoaderFactory
import coil3.network.ktor3.KtorNetworkFetcherFactory
import coil3.request.crossfade

/**
 * Installs a Coil 3 singleton `ImageLoader` that fetches over Ktor 3.
 *
 * Coil 3's commonMain ships `NetworkFetcher` only for Android/JVM hosts —
 * iOS, Wasm, and JS need an explicit fetcher factory. Wiring Ktor's
 * `KtorNetworkFetcherFactory` here makes `SubcomposeAsyncImage` (used by
 * `FullColorIconsPage`) work uniformly across every Compose Multiplatform
 * target.
 *
 * `setSingletonImageLoaderFactory` is a Compose-aware variant of Coil's
 * `SingletonImageLoader.setSafe(...)` — it remembers the loader for the
 * current LocalPlatformContext and won't re-install on recomposition.
 */
@Composable
internal fun setUpCoilForKtor() {
    setSingletonImageLoaderFactory { context ->
        ImageLoader.Builder(context)
            .components { add(KtorNetworkFetcherFactory()) }
            .crossfade(true)
            .build()
    }
}
