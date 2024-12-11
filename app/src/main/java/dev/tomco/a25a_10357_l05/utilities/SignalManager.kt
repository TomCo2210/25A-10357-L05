package dev.tomco.a25a_10357_l05.utilities

import android.content.Context
import android.content.Context.VIBRATOR_SERVICE
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity.VIBRATOR_MANAGER_SERVICE
import java.lang.ref.WeakReference

class SignalManager private constructor(context: Context) {
    private val contextRef = WeakReference(context)

    fun vibrate() {
        contextRef.get()?.let { context ->
            val vibrator: Vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val vibratorManager =
                    context.getSystemService(VIBRATOR_MANAGER_SERVICE) as VibratorManager
                vibratorManager.defaultVibrator
            } else {
                context.getSystemService(VIBRATOR_SERVICE) as Vibrator
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                val SOSPattern = longArrayOf(
                    0,
                    200,
                    100,
                    200,
                    100,
                    200,
                    300,
                    500,
                    100,
                    500,
                    100,
                    500,
                    300,
                    200,
                    100,
                    200,
                    100,
                    200
                )

                val waveFormVibrationEffect = VibrationEffect.createWaveform(
                    SOSPattern,
                    -1
                )

                val oneShotVibrationEffect = VibrationEffect.createOneShot(
                    500,
                    VibrationEffect.DEFAULT_AMPLITUDE
                )

                vibrator.vibrate(oneShotVibrationEffect)
//                vibrator.vibrate(waveFormVibrationEffect)
            } else {
                vibrator.vibrate(500)
            }
        }
    }

    fun toast(text: String) {
        contextRef.get()?.let { context ->
            Toast
                .makeText(
                    context,
                    text,
                    Toast.LENGTH_LONG
                )
                .show()
        }
    }

    companion object {
        @Volatile
        private var instance: SignalManager? = null

        fun init(context: Context): SignalManager {
            return instance ?: synchronized(this) {
                instance ?: SignalManager(context).also { instance = it }
            }
        }

        fun getInstance(): SignalManager {
            return instance ?: throw IllegalStateException(
                "SignalManager must be initialized by calling init(context) before use."
            )
        }
    }

}