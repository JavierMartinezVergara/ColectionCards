package com.javiermtz.localdata

import com.javiermtz.localdata.models.Cards
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LocalDataSourceImpl : LocalDataSource {
    override fun getCards(): Flow<List<Cards>> {
        return flow {
            emit(
                listOf(
                    Cards(
                        id = 1,
                        name = "Wolverine",
                        image = R.drawable.wolverine,
                        oddity = 1,
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
                        oddity = 4,
                        description = "Having created a wondrous suit of armor to keep himself alive, Tony has revised it dozens of times, each version with increased capabilities, faster operation, reduced energy usage, and adaptability to the greatest threats the universe has to offer.",
                        category = ""
                    ),
                    Cards(
                        id = 5,
                        name = "Hulk",
                        image = R.drawable.hulk,
                        oddity = 5,
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
                        oddity = 2,
                        description = "Victor Von Doom overcame his difficult childhood to become one of the world’s most brilliant scientists—though, at every turn, he saw his achievements outdone by a man called Reed Richards.",
                        category = ""
                    ),
                    Cards(
                        id = 8,
                        name = "Loki",
                        image = R.drawable.loki,
                        oddity = 1,
                        description = "The abandoned son of Frost Giant royalty, Loki Laufeyson was rescued from his home realm of Jotunheim and raised as a prince of Asgard by King Odin. Soon Loki became the God of Mischief and became a potent agent of evil and chaos across the realms.",
                        category = ""
                    ),
                    Cards(
                        id = 9,
                        name = "Enchantress",
                        image = R.drawable.enchantress,
                        oddity = 5,
                        description = "Learning spells and sorcery at a young age, the Asgardian goddess Amora grows up to become a formidable sorceress. She often employs her allure and mystical abilities to control the hearts and minds of others.",
                        category = ""
                    ),
                    Cards(
                        id = 10,
                        name = "Venom",
                        image = R.drawable.venom,
                        oddity = 4,
                        description = "When Spider-Man acquired a living symbiote costume, he had no idea it would later spawn a major adversary. Though often a foe to the Wallcrawler, Venom does possess some kind of morality—avoiding harm to the innocent and bringing down the guilty.",
                        category = ""
                    ),
                    Cards(
                        id = 11,
                        name = "Daredevil",
                        image = R.drawable.daredevil,
                        oddity = 4,
                        description = "As a boy, Matt Murdock lost his sight—and gained superhuman senses—in an accident that taught him to live without fear. He went on to study law, leading him to a life of crime fighting in New York; as both a lawyer and as the vigilante Daredevil.",
                        category = ""
                    ),
                    Cards(
                        id = 12,
                        name = "Thanos",
                        image = R.drawable.thanos,
                        oddity = 2,
                        description = "The Mad Titan called Thanos is known across all reality as one of the most powerful beings in existence. Obsessed with order and fate, the god works tirelessly to bring all living things to heel—to make the universe as he sees it should be.",
                        category = ""
                    ),
                    Cards(
                        id = 13,
                        name = "Doctor Octopus",
                        image = R.drawable.doctor_octopus,
                        oddity = 4,
                        description = "Unfortunately, an experiment by passioned scientist Dr. Otto Octavius becomes unstable and fuses a set of artificial intelligent mechanical tentacles to Otto’s body and brain, leading him to become the powerful super villain Doctor Octopus",
                        category = ""
                    ),
                    Cards(
                        id = 14,
                        name = "Moon Knight",
                        image = R.drawable.moon_night,
                        oddity = 5,
                        description = "Struggling with multiple personalities and amoral inclinations, Marc Spector fights on against all odds as the cloaked avenger Moon Knight.",
                        category = ""
                    ),
                    Cards(
                        id = 15,
                        name = "Magneto",
                        image = R.drawable.magneto,
                        oddity = 4,
                        description = "Harnessing his powerful magnetic abilities, he has become a radical freedom fighter in the name of his kind. His only priority is the preservation of the mutant race—even at the expense of what some might deem to be the greater good.",
                        category = ""
                    ),
                    Cards(
                        id = 16,
                        name = "Scarlet Witch",
                        image = R.drawable.scarlet_witch,
                        oddity = 1,
                        description = "One of the most powerful magic-wielders on the planet, the Scarlet Witch casts her spells to aid the downtrodden as an Avenger while seeking out the roots of sorcery wherever they may grow.",
                        category = ""
                    ),
                    Cards(
                        id = 17,
                        name = "Captain America",
                        image = R.drawable.captain_america,
                        oddity = 2,
                        description = "When Steve Rogers enlisted to fight in World War II, he didn’t do it to become a hero, or an icon, or a legend; he did it because he felt it was the right thing to do.",
                        category = ""
                    ),
                    Cards(
                        id = 18,
                        name = "Haweye",
                        image = R.drawable.haweye,
                        oddity = 3,
                        description = "With a wit as quick as an arrow, Clint Barton used his incredible marksmanship and combat skills to become an efficient fighter on his own as well as with the Avengers. He may not have super powers, but he has his team’s back.",
                        category = ""
                    ),
                    Cards(
                        id = 19,
                        name = "Bullseye",
                        image = R.drawable.bullseye,
                        oddity = 4,
                        description = "A mercenary of mystery, nothing is really known about the man called Bullseye. Once, he was captured and interrogated in a highly secured U.S. prison, and he related many details about his early life, such as the time his brother set fire to their home in an attempt to kill their father.",
                        category = ""
                    ),
                    Cards(
                        id = 20,
                        name = "Jane Foster",
                        image = R.drawable.jane_foster,
                        oddity = 1,
                        description = "After Thor (Odinson) was deemed no longer worthy of wielding Mjolnir, Jane Foster was telepathically drawn to the Moon where Mjolnir lay in wait. Upon lifting the hammer, Jane underwent a physical transformation and took on the powers of Thor.",
                        category = ""
                    ),
                    Cards(
                        id = 21,
                        name = "Doctor Strange",
                        image = R.drawable.doctor_strange,
                        oddity = 4,
                        description = "As Earth’s Sorcerer Supreme, Doctor Strange wields arcane spells and mystical artifacts to defend the planet against malevolent threats.",
                        category = ""
                    ),
                    Cards(
                        id = 22,
                        name = "Namor",
                        image = R.drawable.namor,
                        oddity = 4,
                        description = "The offspring of an Atlantean princess and an American explorer, the powerful mutant Namor is a force to behold. While he occasionally leaves his kingdom to work with - or fight against - humanity, Atlantis is always his utmost priority.",
                        category = ""
                    ),
                    Cards(
                        id = 23,
                        name = "Charles Xavier",
                        image = R.drawable.charles_xavier,
                        oddity = 4,
                        description = "While traveling the world, young mutant telepath Charles Xavier befriended fellow mutant Magnus (Max Eisenhardt), but their dichotomous beliefs on mutant/human relations drove a wedge between them.",
                        category = ""
                    ),
                    Cards(
                        id = 24,
                        name = "Cyclops",
                        image = R.drawable.cyclops,
                        oddity = 1,
                        description = "Scott Summers was the first of two sons born to Major Christopher Summers, a test pilot for the U.S. Air Force, and his wife Katherine. Christopher was flying his family home from vacation when their plane was attacked by a spacecraft from the interstellar Shi'ar Empire.",
                        category = ""
                    ),
                    Cards(
                        id = 25,
                        name = "Deadpool",
                        image = R.drawable.deadpool,
                        oddity = 3,
                        description = "Wade Wilson was born in Canada, but grew up to become the least Canadian person ever. When it comes to the Merc with a Mouth, with great power comes no responsibility.",
                        category = ""
                    ),
                    Cards(
                        id = 26,
                        name = "Cable",
                        image = R.drawable.cable,
                        oddity = 5,
                        description = "Meet Nathan Summers, time-traveling soldier and original leader of the mutant commando team, X-Force! The son of Cyclops and a clone of Jean Grey, Cable was raised by dissidents of Apocalypse in a far-flung future. He has limitless telepathic power and is always armed to the teeth—but his great weakness is the techno-organic virus inside of him that he must constantly contain.",
                        category = ""
                    ),
                    Cards(
                        id = 27,
                        name = "TaskMaster",
                        image = R.drawable.taskmaster,
                        oddity = 2,
                        description = "Anthony “Tony” Masters is born with a natural ability that enables him to replicate observed action. He uses it to duplicate Super Hero moves and becomes the criminal, yet sometimes government-sanctioned, trainer known as the Taskmaster.",
                        category = ""
                    ),
                    Cards(
                        id = 28,
                        name = "Mile Morales",
                        image = R.drawable.mile_morales,
                        oddity = 2,
                        description = "In the alternate reality of Earth-1610, a young New York City teen was bitten by a genetically enhanced spider. When the Peter Parker of that dimension was killed, the teen—named Miles Morales—was inspired to take up the fallen mantle.",
                        category = ""
                    ),
                    Cards(
                        id = 29,
                        name = "Dagger",
                        image = R.drawable.dagger,
                        oddity = 5,
                        description = "Tandy found her perfect powered partner by accident, but her bond with Tyrone has made Cloak and Dagger a formidable pair. Dagger’s light forces are the ideal complement to Cloak’s darkness, and together they fight to keep New York City safe.",
                        category = ""
                    ),
                    Cards(
                        id = 30,
                        name = "Cloak",
                        image = R.drawable.cloak,
                        oddity = 1,
                        description = "When Tyrone and Tandy were both transformed into Cloak and Dagger, Tyrone became a being of darkness that could both terrify and shelter people with the power of his cloak. With Dagger by his side, he can stay in balance and protect those in need.",
                        category = ""
                    ),
                    Cards(
                        id = 31,
                        name = "Vision",
                        image = R.drawable.vision,
                        oddity = 3,
                        description = "Built by man, but forged by fate, the amazing android Vision commands unearthly powers and abilities to fight for humanity while seeking his own best purpose.",
                        category = ""
                    ),
                    Cards(
                        id = 32,
                        name = "Ultron",
                        image = R.drawable.ultron,
                        oddity = 4,
                        description = "Robot. Megalomaniacal genius. Science experiment gone wrong. Take your pick because any of those descriptions fit Ultron, perhaps the most recognizable enemy ever to oppose the Avengers.",
                        category = ""
                    ),
                    Cards(
                        id = 33,
                        name = "Galactus",
                        image = R.drawable.galactus,
                        oddity = 3,
                        description = "Sole survivor of the universe existing before the Big Bang, Galactus is perhaps the most feared being in the cosmos. Untold billions of years ago, he was born the humanoid Galan on the planet Taa",
                        category = ""
                    ),
                    Cards(
                        id = 34,
                        name = "Carnage",
                        image = R.drawable.carnage,
                        oddity = 5,
                        description = "Carnage was once a serial killer known as Cletus Kasady, and became Carnage after merging with the offspring of the alien symbiote called Venom during a prison breakout. The symbiote amplified his psychotic nature making him even less mentally stable than he had been previously, and therefore even more dangerous.",
                        category = ""
                    ),
                    Cards(
                        id = 35,
                        name = "Abomination",
                        image = R.drawable.abomination,
                        oddity = 3,
                        description = "As a result he was permanently transformed into a massive green-skinned monster whose physical power was equivalent to, if not greater than, that of the Hulk. While he was able to maintain his normal level of self-control and intelligence after this transformation, he is unable to return to human form.",
                        category = ""
                    )

                )
            )
        }
    }
}
