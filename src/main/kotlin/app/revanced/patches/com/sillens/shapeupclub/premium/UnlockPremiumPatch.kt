package app.revanced.patches.com.sillens.shapeupclub.premium

import app.revanced.util.exception
import app.revanced.patcher.data.BytecodeContext
import app.revanced.patcher.extensions.InstructionExtensions.addInstructions
import app.revanced.patcher.patch.BytecodePatch
import app.revanced.patcher.patch.annotation.CompatiblePackage
import app.revanced.patcher.patch.annotation.Patch
import app.revanced.patches.com.sillens.shapeupclub.premium.fingerprints.CheckPremiumFingerprint
import app.revanced.patches.nyx.misc.pro.fingerprints.CheckProFingerprint

@Patch(
    name = "Unlock premium",
    compatiblePackages = [CompatiblePackage("com.sillens.shapeupclub", ["16.2.0"])]
)
@Suppress("unused")
object UnlockPremiumPatch : BytecodePatch(setOf(CheckPremiumFingerprint)) {
    override fun execute(context: BytecodeContext) = CheckPremiumFingerprint.result?.mutableMethod?.addInstructions(
            0,
            """
                const/4 v0, 0x1
                return v0
            """
    ) ?: throw CheckPremiumFingerprint.exception
}