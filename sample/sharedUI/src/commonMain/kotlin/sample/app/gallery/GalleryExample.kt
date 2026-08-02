package sample.app.gallery

/**
 * Marks a self-contained composable whose source is worth showing next to its
 * preview.
 *
 * `:sample:galleryKsp` reads the annotated function back from disk at compile
 * time and exposes its body as `GallerySources.<functionName>`, so the code the
 * user copies from the demo is literally the code that rendered the preview.
 *
 * @param page the widget page the example belongs to, e.g. `"YaruSwitch"`.
 * @param title the example label shown on the card, e.g. `"States"`.
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.SOURCE)
annotation class GalleryExample(
    val page: String,
    val title: String,
)
