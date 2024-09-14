package app.revanced.patches.com.sillens.shapeupclub.premium.fingerprints

import app.revanced.patcher.fingerprint.MethodFingerprint

internal object CheckPremiumFingerprint : MethodFingerprint(
    customFingerprint = { methodDef, _ ->
        methodDef.definingClass.endsWith("ApiUserProfile;") && methodDef.name == "getPremium"
    }
)
