package com.javiermtz.colectioncards.domain

import com.javiermtz.colectioncards.domain.models.CardsDTO
import com.javiermtz.colectioncards.domain.models.User
import com.javiermtz.localdata.R
import javax.inject.Inject

class GetUserUseCase @Inject constructor() {

    operator fun invoke(): User {
        return User(
            id = 41235,
            name = "Juan Ortega",
            setOf(
                CardsDTO(
                    id = 2,
                    name = "Black Widow",
                    image = R.drawable.black_widow,
                    description = "A deadly assassin is closing in on Natasha Romanoff. Now Natasha must reunite with an unlikely group of spies from her past in order to survive and stop a lethal force from being unleashed on the world."
                ),
                CardsDTO(
                    id = 4,
                    name = "Iron Man",
                    image = R.drawable.iron_man,
                    description = "Having created a wondrous suit of armor to keep himself alive, Tony has revised it dozens of times, each version with increased capabilities, faster operation, reduced energy usage, and adaptability to the greatest threats the universe has to offer."

                )
            )
        )
    }
}
