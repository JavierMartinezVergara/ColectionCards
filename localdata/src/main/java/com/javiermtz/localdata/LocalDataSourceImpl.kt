package com.javiermtz.localdata

import com.javiermtz.localdata.models.Cards
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LocalDataSourceImpl : LocalDataSource {
    override fun getCards(): Flow<List<Cards>> {
        return flow {
            listOf(
                Cards(
                    id = 1,
                    name = "Wolverine",
                    image = R.drawable.wolverine,
                    oddity = 3,
                    description = "The result of both genetic mutation and the horrific capabilities of man, the man known to many solely as Wolverine has fought past unspeakable traumas to become one of the most dedicated forces for good in the Marvel Universe!",
                    category = ""
                ),
                Cards(
                    id = 2,
                    name = "Black Widow",
                    image = R.drawable.black_widow,
                    oddity = 3,
                    description = "A deadly assassin is closing in on Natasha Romanoff. Now Natasha must reunite with an unlikely group of spies from her past in order to survive and stop a lethal force from being unleashed on the world.",
                    category = ""
                ),
                Cards(
                    id = 3,
                    name = "War Machine",
                    image = R.drawable.war_machine,
                    oddity = 3,
                    description = "They may not always see eye to eye, but James “Rhodey” Rhodes and Tony Stark have formed a close camaraderie since they first met. Rhodes provides a helping hand in a fight – with the help of his War Machine armor, he can level the playing field.",
                    category = ""
                ),
                Cards(
                    id = 4,
                    name = "Iron Man",
                    image = R.drawable.iron_man,
                    oddity = 3,
                    description = "Having created a wondrous suit of armor to keep himself alive, Tony has revised it dozens of times, each version with increased capabilities, faster operation, reduced energy usage, and adaptability to the greatest threats the universe has to offer.",
                    category = ""
                ),
                Cards(
                    id = 5,
                    name = "Hulk",
                    image = R.drawable.hulk,
                    oddity = 3,
                    description = "Dr. Bruce Banner lives a quiet life, until he saves the life of teenager Rick Jones from a gamma bomb explosion. After this, the mild-mannered scientist transforms into a powerful being called the Hulk whenever he gets angry.",
                    category = ""
                ),
                Cards(
                    id = 6,
                    name = "Spider Man",
                    image = R.drawable.spiderman,
                    oddity = 3,
                    description = "Bitten by a radioactive spider, Peter Parker’s arachnid abilities give him amazing powers he uses to help others, even while his personal life continues to offer plenty of obstacles.",
                    category = ""
                ),
                Cards(
                    id = 7,
                    name = "Doctor Doom",
                    image = R.drawable.doctordoom,
                    oddity = 3,
                    description = "Victor Von Doom overcame his difficult childhood to become one of the world’s most brilliant scientists—though, at every turn, he saw his achievements outdone by a man called Reed Richards.",
                    category = ""
                ),
                Cards(
                    id = 8,
                    name = "Loki",
                    image = R.drawable.loki,
                    oddity = 3,
                    description = "The abandoned son of Frost Giant royalty, Loki Laufeyson was rescued from his home realm of Jotunheim and raised as a prince of Asgard by King Odin. Soon Loki became the God of Mischief and became a potent agent of evil and chaos across the realms.",
                    category = ""
                ),
                Cards(
                    id = 9,
                    name = "Enchantress",
                    image = R.drawable.enchantress,
                    oddity = 3,
                    description = "Learning spells and sorcery at a young age, the Asgardian goddess Amora grows up to become a formidable sorceress. She often employs her allure and mystical abilities to control the hearts and minds of others.",
                    category = ""
                ),



            )
        }
    }
}
