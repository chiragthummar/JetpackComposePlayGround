package com.example.jetpackcomposeplayground

import android.net.Uri

object Constants {
    const val TAG = "MyTag"

    var OPEN_AD_ID = ""
    var BANNER_AD_ID = ""
    var INTERSTITIAL_AD_ID = ""
    var REWARDED_AD_ID = ""
    var NATIVE_AD_ID = ""
    var REWARDED_INTER_AD_ID = ""
    var INTER_AD_TIME = 30000
    var QUREKA_URL = ""
    var OTHER_APP = ""

    var FORCE_UPDATE = false
    var UPDATE_URL = ""
    var PLAY_STORE_VERSION_CODE = 1
    var MSG_PASS = ""

    val FOLDER_NAME = "AI ChatGPT4"

    var NOTIFY_FREQUENCY = 2
    var MAX_DAYS = 2


    //
    val KEY_SENDER_NAME = "sender"
    val KEY_ROBOT_NAME = "robot"
    val KEY_PDF_NAME = "pdf_name"
    val KEY_PDF_BORDER = "pdf_border"
    val KEY_SPEECH_LANGUAGE_CODE = "speech_code"
    val KEY_SPEECH_LANGUAGE_CODE_2 = "speech_code_2"
    val KEY_SPEECH_LANGUAGE = "speech_language"
    val KEY_SPEECH_LANGUAGE_2 = "speech_language_2"
    val KEY_APP_LANGUAGE = "app_language"
    val KEY_APP_LANGUAGE_CODE = "app_code"
    val KEY_PROFILE_IMAGE = "profile_image"
    val KEY_PRIVATE_POST_STATUS = "see_private_post"
    val KEY_VIEW_STORIES = "view_stories"
    val KEY_SHOW_HIDE_STORIES = "show_hide_stories"
    val KEY_PERMITTED_URI = "main_uri"
    val KEY_WHATSAPP_URI = "whatsapp_uri"
    val KEY_WHATSAPP_B_URI = "whatsapp_b_uri"

    //
    val KEY_SELCTED_CHAT = "selected_chat"
    val KEY_PDF = "pdf"


    val KEY_COOKIES = "cookies"
    val KEY_CSRF = "csrf"
    val KEY_SESSIONID = "sessionid"
    val KEY_USERID = "userid"
    val KEY_ISINSTALOGIN = "islinstalogin"


    var SENDER = ""
    var RECEIVER = ""
    var PASS = ""

    var actualUriForMatching: Uri? = null
    var whatsappUriForMatching: Uri? = null
    var whatsappBusinessUriForMatching: Uri? = null

}

object Directory {
    const val DIR_ALL = "All"
    const val DIR_TIKTOK = "Tiktok"
    const val DIR_INSTAGRAM = "Instagram"
    const val DIR_TWITTER = "Twitter"
    const val DIR_WHATSAPP = "Whatsapp"
    const val DIR_WHATSAPP_BZ = "WhatsappBiz"
    const val DIR_STORY = "Story"
    const val DIR_WHATSAPP_STATUS = "WhatsappStatus"
    const val DIR_WHATSAPP_B_STATUS = "WhatsappBusinessStatus"
    const val DIR_LINKEDIN = "LinkedIn"
    const val DIR_FACEBOOK = "Facebook"
    const val ROOT_FOLDER_NAME = "AllVideoDownloader2023"
    const val TWITTER_PACKAGE = "com.twitter.android"
    const val INSTAGRAM_PACKAGE = "com.instagram.android"
    const val TIKTOK_PACKAGE = "com.zhiliaoapp.musically"
    const val WHATSAPP_PACKAGE = "com.whatsapp"
    const val WHATSAPP_BUSINESS_PACKAGE = "com.whatsapp.w4b"
    const val FACEBOOK_PACKAGE = "com.facebook.katana"
    const val LINKEDIN_PACKAGE = "com.linkedin.android"
}