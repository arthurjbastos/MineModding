package net.doremista.item.customBooks;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomBooks {
    public static ItemStack createCustomWrittenBook(String title, String author, List<String> pages) {
        ItemStack book = new ItemStack(Items.WRITTEN_BOOK);
        NbtCompound tag = new NbtCompound();

        // Define o título e o autor
        tag.putString("title", title);
        tag.putString("author", author);

        // Define as páginas
        NbtList pagesTag = new NbtList();
        for (String page : pages) {
            pagesTag.add(NbtString.of(page));
        }
        tag.put("pages", pagesTag);

        // Definir a geração do livro (0 = original)
        tag.putInt("generation", 0);

        // Define que o livro foi resolvido
        tag.putBoolean("resolved", true);

        // Aplica a tag ao item
        book.setNbt(tag);

        return book;
    }

    public static List<ItemStack> createAllCustomBooks() {
        List<ItemStack> books = new ArrayList<>();

        // Custom Written Book  ** TEMPLATE **

//        books.add(createCustomWrittenBook(
//                "Title",
//                "Author",
//                Arrays.asList("Page 1",
//                        "Page 2",
//                        "Page 3")
//        ));

        // Rubber Chickens 0
        books.add(createCustomWrittenBook(
                "About Rubber Chickens",
                "Lauren",
                Arrays.asList("Rubber Chickens are peculiar creatures, a rare species found in our world, primarily in the region of Disco and on remote islands such as the Bargain Isles. Their origins remain elusive and enigmatic, though it is widely believed that they",
                        "have a connection to deafening Ilums, which evolved from common chickens through some form of bizarre mutation involving rubber and the distinctive clucking sound. These creatures are often regarded as symbols of power and are sometimes kept as exotic",
                        "pets. However, their most prominent, albeit inhumane, use is far more dangerous: certain individuals have discovered how to harness the agonizing sound produced by these animals to craft weapons reminiscent of Bardic magic. Some of these",
                        "weapons still contain living Rubber Chickens, while others are constructed from the remains of chickens that have been fed specific materials to induce desired properties, causing harmful alterations to the environment or living beings, in a",
                        "manner akin to the magical effects seen in Bardic lore. Breeders of Rubber Chickens are known to be exceptionally wealthy, profiting from the sale of their eggs, meat, or weapons fashioned from these creatures. For scientific",
                        "purposes, I have outlined a few steps in the creation of such weapons: feeding the chicken a precise amount of gold, diamond, or Hardagsteel bars appears to result in highly potent armaments. Additionally, my research indicates",
                        "that the creature must also ingest a substantial quantity of neutralized Ilums, in the form of small fragments or similar matter. This combination should suffice to transform Rubber Chickens into instruments of war.")
        ));

        // Carminox 1
        books.add(createCustomWrittenBook(
                "Carminox; Origins and Evolution",
                "Arturo Furbach",
                Arrays.asList("Throughout my research on the origin and evolution of the Carminox, I discovered that this species emerged from a deep corruption of the Lumandias, caused by the malevolent influence of Lokhran in ancient times.",
                        "The Lumandias, once vibrant and harmonious creatures, were gradually transformed under this corrupting force, losing their pure essence and taking on a crimson, corrupted form. This transformation not only altered their",
                        "physical appearance but also corrupted their Ilums, reconfiguring their very nature and purpose. The Carminox, as a result of this corruption, acquired formidable destructive abilities, capable of contaminating and corrupting vast",
                        "regions, turning beings and objects into distorted versions of themselves. Their presence not only disrupts the balance of the environment but also facilitates the proliferation of malevolent entities and the collapse of natural",
                        "order. Moreover, the Carminox possess the alarming ability to multiply at a rate surpassing the natural growth of their surroundings, making their threat even more severe. Following the corruption of some Lumandias, Isabel, one of the",
                        "guardians of balance, created the Alcatraz Forest as a sanctuary to protect the remaining Lumandias from Lokhran’s growing influence. This sanctuary became a bastion of life and harmony, while the Carminox proliferated beyond its borders,",
                        "spreading to other regions of the World of Terras. The early Carminox, with their monstrous appearance and chaotic nature, sowed widespread destruction. However, over time, an unusual event occurred: Evelyn, a Carminox, developed",
                        "an exceptional level of self-awareness and intelligence, something rare among her kind. In this new state of consciousness, Evelyn emerged as a leader and began a reign of chaos, corrupting nature and destabilizing the balance that",
                        "still existed outside the Alcatraz Forest. The situation worsened following the Portals Incident, when two famous brothers and warriors, Layla and Pipe accidentally arrived in the abandoned dimension dominated by the Carminox. Evelyn",
                        "was defeated in this encounter, but an unexpected event gave rise to a clone that was part human, part Carminox. Initially, the one called as \"Evil Pipe\" displayed some of the benevolent qualities of the original Bard, but",
                        "exposure to the harsh environment turned him into a darker figure. Driven by the pursuit of power and the lack of positive guidance, his corruption deepened. In his rise, Evil Pipe resurrected Evelyn, now empowered with new abilities.",
                        "Together, with doubled strength, they destroyed what remained of life in the World of Terras. In response to this devastation, the deity Observer intervened, creating a dimensional portal that allowed the surviving",
                        "inhabitants to escape to our world, while that dimension was about to be extermined by the cosmic laws. However, Pipe's Carminox Clone and Evelyn followed them through the portal, leading an army of Carminox and human followers, known as",
                        "Evilians, who embraced the ideology of Rokirism. This event marked the beginning of the Great War, where the lust for power and destruction threatened to further devastate the balance between worlds. These accounts are the",
                        "result of long and detailed analysis regarding the origin, evolution, and impact of the Carminox and their influence on the imbalance between natural and corrupted forces in the World of Terras and beyond.",
                        "Praised be Lokhran.")
        ));

        // Verdanova 2
        books.add(createCustomWrittenBook(
                "The Verdanova and the Lumandias",
                "Lauren",
                Arrays.asList("Verdanova, one of the Celestes, stands as a guardian of nature, ensuring its protection from large-scale destruction. Known as the ancient tree of Alcatraz Forest, Verdanova once drew fireflies that illuminated the night, drawn to the",
                        "magical sap flowing through its bark. Upon becoming a Celeste, the fireflies transformed into ever-burning candles that neither melt nor harm the tree. The tree's magical sap is not only the source of its strength but also",
                        "central to the survival of the Lumandias. This sap enhances physical abilities, promotes healing, and serves as a vital food source for the inhabitants of Alcatraz Forest. The Lumandias, a nearly extinct green-skinned species, once",
                        "thrived in the World of Terras, created by Isabel as part of her primordial design. Their deep connection to nature allowed them to harmonize with the world's music, drawing power and balance from their surroundings. However, the",
                        "corruption of Lokhran and subsequent dimensional instability shattered this harmony, altering their fate forever. For the Lumandias, Verdanova’s magical sap was essential to their survival. It was not just sustenance; it",
                        "amplified their natural abilities and powers. The sap was a source of healing and strength, meaning that any threat to Verdanova's life posed an existential danger to the Lumandias as a whole.  Alcatraz Forest, created by Isabel as a",
                        "sanctuary, shielded the Lumandias from Lokhran's malevolent influence. The forest was a magical and vibrant haven, safeguarded by Verdanova’s magic, which sustained a flourishing ecosystem of unique flora, magical",
                        "fauna, and enchanted beings. It was a realm where balance and beauty were preserved against all odds, a sanctuary that thrived in perfect harmony. Yet, even this sanctuary was not immune to Lokhran’s corruption. His",
                        "influence spread into Alcatraz, unraveling the delicate balance that once existed. The Lumandias were driven into exile, forced to abandon their homes and take refuge in deep caves. In these subterranean realms, they adapted to new",
                        "conditions, developing a culture that reflected their difficult circumstances. Despite their exile, they clung to the memories of their homeland, striving to preserve their knowledge and traditions.",
                        "Verdanova acts as a great entity, encompassing every biological form related to this species of tree, sharing its mind between each root and leaf. I cannot say for sure where the original Verdanova is or was, but its branches are still",
                        "found in several species of trees, containing the same sap and an orange trunk color, named Verdanova by humans. I firmly believe that the sap found in these subspecies of Verdanova is only a fraction of its influence and power of the original",
                        "sap, however, it is undeniable that it has healing properties. There is still research underway to discover the origin of the healing properties of the sap of the Verdanova tree, although several researchers have already given",
                        "themselves completely to the theory that it is simply a blessing from the Celeste acting on the flora of our world.")
        ));

        // Neeth Nicael 3
        books.add(createCustomWrittenBook(
                "Neeth Nicael",
                "Hycarus, the Oracle",
                Arrays.asList("In the shadowed halls of Lux, a legend was born, Neeth Nicael, a warrior and founder of the most renowned security company in the city-state. His tale is one of loss, vengeance, and redemption, woven into the very fabric of Lux’s",
                        "tumultuous history. Yet, his story does not begin with bloodshed and battle, but in the quiet privilege of an elite family, far from the chaos that would soon engulf his life. Neeth Nicael’s presence commands respect and caution. Tall and",
                        "lean, his long hair is slicked back into a ponytail, giving him a sharp, almost regal appearance. His attire is simple, yet functional, clothing secured by iron plates that serve as lightweight armor. But it is his weapons that",
                        "truly define him. Curved blades extend from his forearms, arching over his hands in a lethal display of craftsmanship. These blades, honed for stealth and silent death, are Neeth’s signature tools in his mastery of assassination and",
                        "covert combat. Neeth Nicael was raised in comfort and luxury. His family owned vast estates and influential factories that powered the capital’s economy. But despite the wealth, his parents were often absent, consumed by their",
                        "roles in managing the family empire. In their place, Neeth’s grandparents nurtured him, offering the love and care that shaped his early years. By the age of sixteen, Neeth was called into the family business, expected to",
                        "shoulder the mantle of his lineage. Days were spent in his father’s office, learning the intricacies of trade and finance. The young man was groomed to lead, but life, as he knew it, was about to unravel in a way no one could have foreseen. The",
                        "turning point in Neeth’s life came with the event that would forever be etched in Lux’s history; the Great Blackout. For five days, darkness blanketed the city as gangs and criminals seized the opportunity to sow chaos. It was a time of fear and",
                        "lawlessness, and the security forces of Lux proved woefully unprepared. The aftermath of those harrowing nights left the Nicael family shattered. Their factories, once pillars of Lux’s economy, were destroyed in the rampage. Employees",
                        "and even members of Neeth’s own family perished in the carnage. The devastation was too much for his father to bear, leading him to take his own life. Neeth’s mother, broken by grief, fell into a deep illness. Left to pick up the pieces, Neeth’s",
                        "soul burned with a single purpose, vengeance. He swore to restore his family’s honor and carve a path to justice. Leveraging the powerful connections his family once held, Neeth did not simply rebuild; he forged a new empire. He pivoted",
                        "the Nicael legacy toward security and the manufacture of weapons. The young man immersed himself in combat training, personally attending academies to hone his skills and forge new alliances. It was here that Neeth became not just a",
                        "businessman, but a fighter, mastering the lethal arts that would soon define him. His invention of the arm-mounted Hardagsteel blades, a fearsome extension of his martial prowess, became symbolic of his rise. With these weapons, he",
                        "formed an elite unit of fighters, bound by loyalty and skill. Their first target was the architect of Lux’s fall, the leader of Monte Kelver, the man behind the Great Blackout. In a swift and brutal assault, Neeth led his forces into the",
                        "heart of Monte Kelver. The battle was fierce, with bullets and blood painting the streets as the price for vengeance. But Neeth, ever the shadow in the chaos, infiltrated the leader’s stronghold. In the dead of night, with",
                        "nothing but the whisper of his blades cutting through the air, he ended the life of the mastermind with a single, silent slash to the throat. The riches of the fallen leader were claimed, but more importantly, Neeth had avenged his",
                        "family. With his vengeance fulfilled and the honor of his family restored, Neeth Nicael returned to Lux as more than just a survivor, he was now a symbol of power. He founded the city’s premier security company, expanding its reach beyond Lux to other",
                        "states. From escorting dignitaries to hunting pirates, Neeth’s services became legendary, securing his place in history. But despite his triumphs, Neeth’s motivations remained deeply personal. His only wish was to protect",
                        "those he loved; his mother, still recovering, and his grandparents who had raised him. His legacy was no longer one of wealth alone, but of strength, resolve, and a relentless pursuit of justice. Neeth Nicael, the shadow warrior of Lux, had",
                        "carved his name into the annals of history, a protector and avenger whose tale would be told for generations."
                )
        ));

        // KATES JOURNAL 4
        books.add(createCustomWrittenBook(
                "Kate's Journal",
                "Kate",
                Arrays.asList("Finally! The first real mission of my life! I joined the Dorémiers on my own; I used to adventure with my father, Viktor, the famous bard of the Island. But nothing we did was like this; we are fighting in a real war! I can't contain my anxiety.",
                        "My father has given me numerous warnings to be careful, as I am not directly trained for this kind of thing yet, but I will be alongside two other warriors, which calms me a bit. I wish Dad were in the group, but he has more specific",
                        "positions in the Dorémiers; he spends all day training the bard soldiers and monitoring the south of the Headquarters. I don’t know much information yet, only that I was placed with these two Dorémiers in our own group. It",
                        "seems Yolanda has a mission that will test our abilities, and the three of us have 'fame' as adventurers. I hope to get to know them better. A week has passed; I received more information, and the day for the mission has been set. The other two coming with me are",
                        "named Neeth and Dra'mor, exotic names, I must say. Neeth has an interesting profile; he specializes in stealth combat and seems very intelligent, having passed the intellectual test with some Dorémiers in under three",
                        "minutes. However, there’s a warning that he has only worked in a group once, which might be a problem. He hails from Lux. Dra'mor, despite the name, was born on the Dó Ré Mi Island; his mother is from F'raz, and his father disappeared before",
                        "his birth. He must have had a troubled childhood. His file says that his mother fled F'raz under unknown circumstances, took the boy with her, but was killed during a crossing to the Capital, a victim of gunfire. He seems to have a",
                        "rebellious and violent trait; I don’t think we will get along well. I also saw my file; 'Kate, a young mage, daughter of a bard and a civilian, from Alpercata, has a leadership posture and is very focused on her work, generally avoids",
                        "violence.' Honestly, I liked my profile, and unlike the others, there wasn’t a page describing the cons. Anyway, the day is approaching. We will meet in the east of the Capital. According to sources, Evilians will attack a nearby",
                        "village, probably attempting to dominate the territory, as this region is predominantly Dorémier. I don’t want to make a bad impression on my two companions, so I will style my slightly blue hair, though short, wear my dark pink robe",
                        "and my golden pendant, which has a thorn-shaped stone in the center. My father gave me that pendant and says the thorn in the center is from the scales of a real Gargullita. I don’t believe that story, but it’s beautiful and eye-catching,",
                        "and it serves as an object of possession for my powers, a kind of backpack for various spells. Just to be sure, I’ll take my Greemoceno dagger, which reflects a rainbow when it catches the sunlight. I know exactly where we",
                        "are going and what we will do there. I know I will probably come back with blood on my hands, but with hundreds of lives saved, and a great reputation with the Dorémiers. The day has arrived. As we walked toward the gate, followed by two guards, I saw",
                        "the well-known Layla training on a dummy. She was slicing through leather and tearing wool with extremely fast movements. Her forehead was sweating, and her brow was constantly furrowed. That scene frightened me; I hadn’t stopped to think",
                        "about what war does to someone’s mind. Layla was a clear example of the mental destruction that chaos causes, but there was no turning back. Neeth walked beside me, very close, as if he had no fear. He was tall, his hair slicked back and tied in a ponytail.",
                        "He wore entirely gray clothing: a jacket, a type of “armor” consisting of iron plates around his body, making an “X” on his chest, long pants, and sneakers, strangely casual for a war. I wondered for a second where he kept his weapons",
                        "until I saw him adjusting the curved blade hidden in his arm. It was thin and curved downward over his hand. I wondered how he hadn’t yet sliced off any fingers, until I looked at his left hand and noticed he was missing his index finger.",
                        "Dra'mor was tall, large, and robust, and appeared very strong. He looked down with his head bowed the entire time. He was nowhere near me and Neeth; he walked as if he wanted to keep his distance. He carried a shotgun on his back and a revolver in a",
                        "holster on his chest. He had only a few scattered hairs on his head, and his skin looked tired, a grayish white. To be honest, he scared me. We left the Headquarters and were alone now, carrying a special cell phone Yolanda gave us. We marched",
                        "east of the Capital; it would be an hour of silent walking if Neeth hadn’t spoken up: “So, you’re famous on the Island, Kate?” I nodded, though with some doubt. He put his hands in his pockets again. I was puzzled by how he managed this",
                        "with those deadly blades protruding, and continued with a slightly imposing tone: “You should know me too. I became more well-known in other parts of the Island for killing the chief thief of Mount Kelver. That guy brought me a lot of trouble.” I",
                        "was shocked to hear him talk about a murder so casually, as if it were an achievement. For a few seconds, I lost the desire to fight alongside these two, but then thought of my father, the Dorémiers, and my reputation, and my anxiety returned.",
                        "Dra'mor followed behind with small steps, still with his head bowed. He hadn’t spoken a word since we left the Headquarters until he stopped and pulled his weapon from the holster to reload it. We saw him stop suddenly and also stopped, waiting",
                        "for him to finish, until Neeth dared to say: “Do you really use all these weapons? You look strong; you don’t need pistols, do you?” I thought of giving him a dirty look, but we weren’t close enough for him to understand that it was quite",
                        "unnecessary. Instead, Dra'mor glared at Neeth, slowly put the weapon back, and looked at the ground again: “Have you ever killed someone with your hands? Or do you need to rely on bird claws?” Neeth briefly took his right hand out of",
                        "his pocket, gave a slight laugh, and kept walking, but I heard him mumble as he turned back: “Bird claws… Bird claws… Hmph.” I tried to stay out of the conversation but couldn’t help noticing that Neeth seemed to have already taken the lead. He walked in",
                        "front of the group and sometimes said, “It’s this way,” even though everyone already knew the path. I can’t lie; I wasn’t comfortable with Neeth taking control of the group as if it were his own. He’s a killer, and despite being intelligent,",
                        "he seems selfish. I can’t let him lead the group his way, so I ran up to his side, leaving Dra'mor even further behind, and addressed Neeth, pretending to try to converse normally: “So, do you know what’s going to happen there? I mean,",
                        "there will be Evilians, but… do we have a plan?” He replied, rolling his eyes as if it were obvious: “Of course. You stay as high up as possible in the village. When you see them coming, let me know the direction. We’ll have the big guy distract them.",
                        "While he holds off some of them, I’ll circle around and kill the leader who directs them. He usually stays in the center of the battalion. Believe me, I have experience with this. Without the leader, they become destabilized, and then it’s just a",
                        "matter of finishing off the rest. In an hour, we’ll be back.” I processed the information in my head and protested: “Okay, an ambush seems good, but what about me?” He laughed quietly and said he had just explained the plan. I was annoyed by",
                        "his arrogance. Besides taking over the group, my presence was ignored, but I didn’t protest. Faster than I thought, we found the village that was going to be attacked. Looking at it now, I understand why Yolanda didn’t",
                        "worry or even wish us good luck. If the Evilians are going to attack this village, there will be at most five of them… It’s just a few houses, a well, and what looks like a small chapel. There can’t be even a hundred residents... Anyway, we",
                        "positioned ourselves on the nearby hill, with the village just below. Dra'mor removed a lens from one of his weapons and gave it to me to use as binoculars. I spotted a caravan in the distance, with the Evilians emblem displayed.",
                        "Neeth took the 'binoculars' from my hands and said, as if he were the only one who saw it: “There! Evilians! They’re to the east of the village. The big guy will go to meet them to distract them. I’ll circle around and attack from behind without",
                        "them noticing. Kate, you stay here.” And he immediately slid down the hill, hitting the ground and running faster than I’d ever seen. Dra'mor leaped and did the same, grabbing the shotgun from his back. I still couldn’t believe",
                        "what he said; they were practically excluding me from the group. So obviously, I tied up my blue hair and slid down to the village. The caravan was quite fast and was already close to the village. Dra'mor stood in front of it. I",
                        "don’t know how, but he was instantly shot in the shoulder by a sniper who appeared from the top of the vehicle. He seemed to feel nothing, didn’t even move, just stood there like a wall. After a moment, he threw his shotgun on the ground, pulled out",
                        "two pistols from his holsters, and fired as if there were no tomorrow, not even aiming, while shouting and making the ground shake. At that moment, all the Evilians jumped out, there were about five of them, armed and furious. I saw Neeth",
                        "appearing from a tree, making a jump (very impressive, I must say), and landing on an enemy, driving his “bird claws” into the man’s head. I was still far from the fight, so I took out a harmonica I carry with me, played it while clutching my",
                        "necklace, and my notes floated over to the Evilians, making them drop their weapons to cover their ears. Dra'mor took advantage of my distraction and ran at one of them, smashing his nose with the butt of his pistol, grabbed him by the neck,",
                        "and threw him onto the caravan, further damaging it. I was scared by all of this but satisfied in a way. They weren’t very friendly, but they knew how to fight. Neeth took out most of them with precise and fatal strikes from his blades. I continued",
                        "playing spells that distracted the Evilians and protected my companions, without hitting anyone. In the end, only one was left, running away in desperation. He couldn’t have been very old, around my age, and seemed to be crying... I",
                        "packed up my things and ignored him, but Dra'mor picked up his shotgun from the ground and, as if it were nothing, almost split the young man in half with a shot to the torso. Everything went silent. They gathered their things and started heading back in the",
                        "direction we came from. The villagers watched, horrified. After levitating the bodies to the caravan and setting it on fire with my magic, I went to the village to calm the residents and gave them the Evilian's weapons, in case they needed to protect",
                        "themselves. Neeth and Dra'mor waited for me from a distance, looking quite impatient. I rejoined them. I decided not to say anything; I knew that blood would be spilled and deaths would happen, it’s a war after all. But I felt a bit uneasy... It didn’t",
                        "need to be so violent; I don’t think I’ve ever seen that much blood in one place before... As we walked back, Dra'mor broke the silence: “We make a great team.” Neeth laughed loudly and agreed. I guess these two liked each other’s",
                        "methods. If this is going to be my team, I need to get used to it. Oh, Isabel, I just want to get home, take a bath, sleep deeply, and erase those screams and blood from my mind.",
                        "At least Dad will be proud. My first mission.")
        ));

//        books.add(createCustomWrittenBook(
//                "Title",
//                "Author",
//                Arrays.asList("Page 1",
//                        "Page 2",
//                        "Page 3")
//        ));


        return books;
    }
}
