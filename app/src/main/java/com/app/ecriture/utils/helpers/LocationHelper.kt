package com.ragilly.utils.helpers

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.util.Log
import com.birjuvachhani.locus.*
import java.util.*

object LocationHelper {

    fun getCurrentLocation(
        context: Context,
        location: (Location) -> Unit,
        isDenied: (String?) -> Unit = {},
        isPermanentlyDenied: (String?) -> Unit = {},
        isSettingsResolutionFailed: (String?) -> Unit = {},
        isSettingsDenied: (String?) -> Unit = {},
        unknownError: (String?) -> Unit = {}
    ) {

        Locus.getCurrentLocation(context) { result ->
            result.location?.let {  /* Received location update */
                location.invoke(it)
            }

            result.error?.let { error -> /* Received error! */
                Log.e("Location", "${error.message}")

                when {
                    error.isDenied -> { /* When permission is denied */
                        isDenied.invoke(error.message)
                    }
                    error.isPermanentlyDenied -> { /* When permission is permanently denied */
                        isPermanentlyDenied.invoke(error.message)
                    }
                    error.isSettingsResolutionFailed -> { /* When location settings resolution is failed */
                        isSettingsResolutionFailed.invoke(error.message)
                    }
                    error.isSettingsDenied -> { /* When user denies to allow required location settings */
                        isSettingsDenied.invoke(error.message)
                    }
                    error.isFatal -> { /* None of above */
                        unknownError.invoke(error.message)
                    }
                }
            }
        }

    }

    fun getAddresses(context: Context?, lat: Double, lng: Double): MutableList<Address> {
        return try {
            val geocoder = Geocoder(context, Locale.getDefault())
            geocoder.getFromLocation(lat, lng, 5) ?: mutableListOf()
        } catch (e: Exception) {
            mutableListOf()
        }
    }

    fun getAddress(context: Context?, lat: Double, lng: Double): Address? {
        return try {
            val geocoder = Geocoder(context, Locale.getDefault())
            val addresses = geocoder.getFromLocation(lat, lng, 5) ?: mutableListOf()
            addresses[0]
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }


}
