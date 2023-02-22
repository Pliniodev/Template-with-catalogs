package com.plinio.dev.template.ui.resources

import cafe.adriel.lyricist.LyricistStrings

data class TemplateStrings(
    val title: String,
)

@LyricistStrings(languageTag = "pt", default = true)
val strings = TemplateStrings(
    title = "Template"
)