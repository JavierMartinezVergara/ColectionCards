package com.javiermtz.colectioncards.domain

import com.javiermtz.colectioncards.domain.models.CardsDTO
import com.javiermtz.colectioncards.domain.models.User
import com.javiermtz.localdata.R.drawable
import javax.inject.Inject

class GetUserUseCase @Inject constructor() {

    operator fun invoke(): User {
        return User(
            id = 41235,
            name = "Juan Ortega",
            setOf(
                CardsDTO(
                    id = 4,
                    name = "Iron Man",
                    image = drawable.iron_man,
                    description = "Having created a wondrous suit of armor to keep himself alive, Tony has revised it dozens of times, each version with increased capabilities, faster operation, reduced energy usage, and adaptability to the greatest threats the universe has to offer.",
                    power = 5
                ),
                CardsDTO(
                    id = 5,
                    name = "Hulk",
                    image = drawable.hulk,
                    description = "Dr. Bruce Banner lives a quiet life, until he saves the life of teenager Rick Jones from a gamma bomb explosion. After this, the mild-mannered scientist transforms into a powerful being called the Hulk whenever he gets angry.",
                    power = 5
                )
            )
        )
    }
}
