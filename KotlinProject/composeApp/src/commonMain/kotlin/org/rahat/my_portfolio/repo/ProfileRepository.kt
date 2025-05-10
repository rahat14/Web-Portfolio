package org.rahat.my_portfolio.repo

import kotlinx.serialization.json.Json
import org.rahat.my_portfolio.data.DeveloperProfile
import org.rahat.my_portfolio.data.info

class ProfileRepository {

    fun loadProfile(): DeveloperProfile {
        val profile: DeveloperProfile = Json.decodeFromString(info)
        return profile
    }

}
