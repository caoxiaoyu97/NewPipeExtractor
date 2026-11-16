/*
 * SPDX-FileCopyrightText: 2018-2024 NewPipe contributors <https://newpipe.net>
 * SPDX-FileCopyrightText: 2026 NewPipe e.V. <https://newpipe-ev.de>
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package org.schabi.newpipe.extractor

/**
 * Static data about various media formats supported by NewPipe, e.g. mime type, extension
 */
public enum class MediaFormat(
    @JvmField
    public val id: Int,

    @JvmField
    public val formatName: String,

    @JvmField
    public val suffix: String,

    @JvmField
    public val mimeType: String
) {
    // video and audio combined formats
    MPEG_4(id = 0x0, formatName = "MPEG-4", suffix = "mp4", mimeType = "video/mp4"),
    v3GPP(id = 0x10, formatName = "3GPP", suffix = "3gp", mimeType = "video/3gpp"),
    WEBM(id = 0x20, formatName = "WebM", suffix = "webm", mimeType = "video/webm"),

    // audio formats
    M4A(id = 0x100, formatName = "m4a", suffix = "m4a", mimeType = "audio/mp4"),
    WEBMA(id = 0x200, formatName = "WebM", suffix = "webm", mimeType = "audio/webm"),
    MP3(id = 0x300, formatName = "MP3", suffix = "mp3", mimeType = "audio/mpeg"),
    MP2(id = 0x310, formatName = "MP2", suffix = "mp2", mimeType = "audio/mpeg"),
    OPUS(id = 0x400, formatName = "opus", suffix = "opus", mimeType = "audio/opus"),
    OGG(id = 0x500, formatName = "ogg", suffix = "ogg", mimeType = "audio/ogg"),
    WEBMA_OPUS(id = 0x200, formatName = "WebM Opus", suffix = "webm", mimeType = "audio/webm"),
    AIFF(id = 0x600, formatName = "AIFF", suffix = "aiff", mimeType = "audio/aiff"),

    /**
     * Same as [AIFF], just with the shorter suffix/file extension
     */
    AIF(id = 0x600, formatName = "AIFF", suffix = "aif", mimeType = "audio/aiff"),
    WAV(id = 0x700, formatName = "WAV", suffix = "wav", mimeType = "audio/wav"),
    FLAC(id = 0x800, formatName = "FLAC", suffix = "flac", mimeType = "audio/flac"),
    ALAC(id = 0x900, formatName = "ALAC", suffix = "alac", mimeType = "audio/alac"),

    // subtitles formats
    VTT(id = 0x1000, formatName = "WebVTT", suffix = "vtt", mimeType = "text/vtt"),
    TTML(
        id = 0x2000,
        formatName = "Timed Text Markup Language",
        suffix = "ttml",
        mimeType = "application/ttml+xml"
    ),
    TRANSCRIPT1(id = 0x3000, formatName = "TranScript v1", suffix = "srv1", mimeType = "text/xml"),
    TRANSCRIPT2(id = 0x4000, formatName = "TranScript v2", suffix = "srv2", mimeType = "text/xml"),
    TRANSCRIPT3(id = 0x5000, formatName = "TranScript v3", suffix = "srv3", mimeType = "text/xml"),
    SRT(id = 0x6000, formatName = "SubRip file format", suffix = "srt", mimeType = "text/srt");

    /**
     * Get the name of the format
     */
    public fun getName(): String {
        return name
    }

    /**
     * Get the filename extension
     */
    public fun getSuffix(): String {
        return suffix
    }

    /**
     * Get the mime type
     */
    public fun getMimeType(): String {
        return mimeType
    }

    public companion object {

        /**
         * Return the friendly name of the [MediaFormat] with the supplied id
         */
        @JvmStatic
        public fun getNameById(id: Int): String {
            return entries.firstOrNull { it.id == id }?.name ?: ""
        }

        /**
         * Return the file extension of the [MediaFormat] with the supplied id
         */
        @JvmStatic
        public fun getSuffixById(id: Int): String {
            return entries.firstOrNull { it.id == id }?.suffix ?: ""
        }

        /**
         * Return the MIME type of the [MediaFormat] with the supplied id
         */
        @JvmStatic
        public fun getMimeById(id: Int): String {
            return entries.firstOrNull { it.id == id }?.mimeType ?: ""
        }

        /**
         * Get the first matching [MediaFormat] by its mimetype or `null`
         */
        @JvmStatic
        public fun getFromMimeType(mimeType: String): MediaFormat? {
            return entries.firstOrNull { it.mimeType == mimeType }
        }

        /**
         * Get all media formats which have the given mime type
         */
        @JvmStatic
        public fun getAllFromMimeType(mimeType: String): List<MediaFormat> {
            return entries.filter { it.mimeType == mimeType }
        }

        /**
         * Get the first [MediaFormat] by its id or `null`
         */
        @JvmStatic
        public fun getFormatById(id: Int): MediaFormat? {
            return entries.firstOrNull { it.id == id }
        }

        /**
         * Get the first matching [MediaFormat] by its suffix or `null`
         */
        @JvmStatic
        public fun getFromSuffix(suffix: String?): MediaFormat? {
            return entries.firstOrNull { it.suffix == suffix }
        }
    }
}
