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

        // Definir a geração do livro (0 = original, 1 = copia do original)
        tag.putInt("generation", 1);

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
                "Carminox: Origins and Evolution",
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
                        "About 'Rokir', or 'The Evil One'...",
                        "Evil Pipe, known as 'Rokir', is a clone of Pipe, accidentally created during a ritual conducted by Evelyn in the World of Terras. As the only being that is half-human and half-Carminox, his initial appearance resembled that of Pipe, the Bard, but ",
                        "his personality and appearance diverged significantly over time. He is characterized by a profound melancholy due to the abandonment he experienced. Lacking the protection of a warrior sister and left to the cruelty of nature, the ",
                        "clone was forced to forge his own path in a world where malevolence was not deliberate, but the natural environment imposed relentless challenges. The absence of guides and positive influences shaped the young clone into a solitary and resilient figure. ",
                        "Faced with the trials of surviving in a merciless landscape, he developed unique skills and strategies. The lack of compassion and isolation fueled a thirst for power, while the residual corruption present in that world grew ",
                        "exponentially each day. This phenomenon, initially unnoticed, escalated rapidly. Eventually, Evil Pipe discovered the ancient dungeon where Evelyn had once performed her rituals, and through an emergency spell, ",
                        "which only a sentient being could execute, he managed to resurrect Evelyn. Evelyn, firmly believing that Evil Pipe was the representative of Lokhran mentioned in the Codex she once possessed, welcomed him and elevated him to a ",
                        "leadership role. Upon arriving in our World, specifically in the city of Codan, the Evil Clone and Evelyn quickly settled in the ruins of an ancient fortress. Using his abilities to demonstrate his power, he was introduced to the ",
                        "citizens as 'Rokir', the title bestowed upon the representative of Lokhran, a figure of immense power and authority. Without further patience for persuasion attempts, they launched a merciless assault on the city. ",
                        "Corrupted Carminox, summoned from the surrounding environment, were unleashed, and their power was used to ravage Codan. This brutal attack forced the inhabitants to surrender, submitting to the new regime and forming the first ",
                        "army known as the Evilians.  With Codan under their control, Evil Pipe and Evelyn solidified their authority and began expanding their influence. Their acts of power and conquest, combined with the growing corruption, transformed the ",
                        "landscapes and creatures in their vicinity. The Evilians army, now more formidable, advanced toward new conquests, forging deals with nations and confronting local warriors and nobles. The absence of heroes such as Layla and Pipe was seen as a strategic ",
                        "opportunity, driving their offensive to secure final victory and total domination over the Do Re Mi World. ",
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
                        "minutes. However, there’s a warning that he has only worked in a group once, which might be a problem. He hails from Lux. Dra'mor, despite the name, was born on the Do Re Mi Island; his mother is from F'raz, and his father disappeared before",
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

        // BARDS BOOK 5
        books.add(createCustomWrittenBook(
                "Bards: A Cosmic Dissertation",
                "Arturo Furbach",
                Arrays.asList("In the world of mystical arts, Bards are the wielders of musical instruments, divided into two distinct categories: Common Bards and Ascended Bards. While this classification exists, the focus of this exploration lies on the ",
                        "Ascended Bards, masters of rhythm who wield Ilums, the energy of the cosmos, for combat through the melodies they create. The magic system of the Bards operates in a unique and special way. When a Bard reaches an advanced level of musical ",
                        "skill and mastery over Ilum, they become capable of 'shattering' their instrument into fragments, absorbing it into themselves. This profound act enables the Bard to summon their instrument instantaneously with just a ",
                        "thought, materializing it in their hand at will. This process is called Sonic Conjuration, an advanced technique that demands years of practice and dedication. By imbuing their instrument with Ilum, the Bard becomes even more ",
                        "powerful, able to access their instrument at any moment and wield their musical magic with greater efficiency. Beyond merely summoning the instrument, the Bard also gains the ability to communicate with its spirit, receiving guidance ",
                        "and counsel from the entity that resides within. However, mastering this technique is not for the faint of heart, it requires immense talent and experience, qualities only the most exceptional Bards possess.",
                        "Ilum Manipulation: The manipulation of Ilum by the Bards is the cornerstone of their magical abilities, and it is categorized into several forms, each with distinct techniques and applications: ",
                        "Ilum Dispersion Form: Bards use Ilum Dispersion to generate bursts of light and sound, concentrating Ilum in their hands before releasing it in a controlled explosion.",
                        "This creates a wave of energy that radiates in multiple directions. This technique proves invaluable in distracting foes or ",
                        "creating a diversion for escape. ",
                        "Melodic Gifts: Melodic Gifts represent the rare and powerful ability some Bards possess to craft music that deeply affects the emotions of those who hear it. These melodies can heal, inspire, or even ",
                        "control minds. Bards with this gift are highly esteemed for their capacity to influence others through the emotive power of music. ",
                        "Physical Damage: Bards can transform their instruments into weapons, dealing direct physical damage to ",
                        "enemies. They achieve this by channeling Ilum into their hands and using specific abilities to strike at their opponents’ weak points. Instruments become extensions of their combat prowess, capable of slashing, cutting, or piercing in a ",
                        "myriad of ways. Beyond physical attacks, Bards can inflict negative effects on their enemies through the power of their music. These effects, such as slowing, weakening, or even blinding, are embedded within the concentrated Ilum ",
                        "of musical notes, allowing Bards to weaken enemies before a full confrontation. ",
                        "Environmental Manipulation: Bards also possess the extraordinary ability to manipulate their surroundings with their music. They can change the ",
                        "weather, trigger earthquakes, or conjure illusions. Through their melodies, the world around them bends to their will, transforming landscapes and shifting the very fabric of reality. Musical Summonings: Some Bards have the rare gift of ",
                        "Musical Summoning, calling forth entities made of Ilum and music itself. These summoned beings act as allies or weapons, taking on diverse forms, animals, fantastic creatures, or even natural elements like lightning or ",
                        "storms. Controlled through music, these entities serve the Bard in combat or fulfill special tasks. However, summoning them demands great concentration and can be exhausting, so Bards must exercise caution and use this ability sparingly. ",
                        "Praised be Lokhran.")
        ));

        // MUTE MAGIC 6
        books.add(createCustomWrittenBook(
                "Silent Magic: The Forbidden Art",
                "Arturo Furbach",
                Arrays.asList("Silent Magic, known as Mute Magic in ancient texts, represents one of the most feared and misunderstood branches of magical study within the World of Do Re Mi. Unlike traditional Bardic magic, which is rooted in harmony, rhythm, and the orderly ",
                        "flow of Ilum energy through structured melodies, Silent Magic embraces discord, unpredictability, and chaos. It manipulates the absence of harmony, crafting erratic and disturbing compositions that break the natural balance of sound ",
                        "and cosmic energy. These melodies, though seemingly incoherent, unlock unstable Ilums capable of yielding immense power, but at a perilous cost. At its core, Silent Magic harnesses the dissonance between musical notes, disrupting the harmony that Bards ",
                        "traditionally use to control their spells. The melodies woven in this art do not follow the rules of structure or rhythm; instead, they are jagged, asymmetrical, and chaotic, invoking the raw forces of the universe. In this disarray lies ",
                        "a reservoir of unbridled energy, an unstable form of Ilum that is difficult to control, yet infinitely more potent than the balanced Ilums used in conventional magic.  Silent Magic is considered a wild and volatile force because it ",
                        "taps into the deep, unfiltered chaos of existence. Where harmonic melodies channel the flow of Ilum smoothly, Silent Magic twists and breaks that flow, warping reality itself. These dissonant energies can rip through the fabric of time, space, and ",
                        "soul, altering the fates of living beings within mere moments. The destabilizing effect of this magic extends beyond the battlefield, influencing the very laws that govern the universe, particularly the Paradoxical Laws, ",
                        "ancient and immutable principles that ensure balance within the cosmos. Due to its destructive potential and the risks it poses to cosmic harmony, Silent Magic has been declared forbidden by nearly every major Bardic ",
                        "institution across the World of Do Re Mi. Its use is heavily restricted, and those who practice it are often labeled as outcasts or heretics. The manipulation of unstable Ilums can trigger catastrophes, not just on a local ",
                        "scale, but across entire realms, as the delicate balance of the cosmos is thrown into disarray. In some cases, practitioners of Silent Magic have inadvertently created rifts in reality, allowing destructive forces to seep into the ",
                        "world. Despite the overwhelming consensus that Silent Magic should remain outlawed, there are those who embrace its forbidden allure. The Rokirists are known for their mastery of Silent Magic. To the Rokirists, the instability of ",
                        "Silent Magic is not a flaw, but a tool, one that allows them to reshape reality to their own ends. The Rokirists believe that by embracing chaos, they can transcend the limitations imposed by traditional Bardic magic. In their view, Silent ",
                        "Magic is the ultimate form of freedom, an art that breaks the chains of order and allows them to impose their own will upon the universe. To them, the potential to manipulate space, control fate, and shatter the very fabric of reality is worth ",
                        "the risk of cosmic imbalance. Only such masters are capable of manipulating such a deep level of reality, so it becomes of utmost importance for a Rokirist to master the art of Mute Magic in order to achieve his goal in favor of Lokhran. ",
                        "Though it offers immense power, the use of Silent Magic comes with profound consequences. Even experienced practitioners cannot always control the volatile Ilums they summon, leading to unintended side effects that can be catastrophic. ",
                        "Silent Magic, by its nature, tends to disrupt not just the immediate environment, but also the user’s mind and body. Prolonged exposure to the chaotic energy can lead to madness, as the discordant forces overwhelm the caster's sense of ",
                        "self and reality. Silent Magic remains a tantalizing, dangerous force, an art of dissonance that, though forbidden, calls to those willing to risk everything for power beyond comprehension. ")
        ));

        // ABOUT ILUMS 7
        books.add(createCustomWrittenBook(
                "The Study of Ilum",
                "Lauren and Yolanda",
                Arrays.asList("At its core, Ilum is a cosmic particle, created from the harmonious fusion of sound, rhythm, and melody. Everything in existence, whether it be a living organism, an inanimate object, or even abstract concepts like time and space, is ",
                        "composed of Ilum. These particles possess a unique property, they are not inert, like ordinary matter, but are instead alive in their own right. Each Ilum has a form of consciousness, albeit one that operates on a cosmic scale, ",
                        "allowing it to organize, merge, or separate as necessary to construct the intricate tapestry of existence.  This phenomenon of self-organization is one of the most intriguing aspects of Ilum. When millions or even billions of these ",
                        "particles unite, they form tangible structures: objects, beings, and forces that shape the World of Do Re Mi. It is as though Ilum carries within it a blueprint for life and creation, assembling itself according to the music of the ",
                        "cosmos. Bards, the traditional manipulators of Ilum, have long understood how to influence these particles through music and rhythm. By playing specific melodies or creating harmonic vibrations, Bards can alter the behavior of Ilum, ",
                        "shaping it to their will. This is the foundation of Bardic magic, a system where the manipulation of Ilum is achieved through sonic resonance.  When a Bard plays an instrument or sings a melody, the sound waves interact with the Ilum particles ",
                        "in their surroundings, causing them to realign or transform. These particles respond to the rhythm and frequency of the music, creating powerful effects that range from healing to destruction. Bards can accelerate, ",
                        "decelerate, or even split Ilum into new forms, depending on the complexity of their musical performance. However, while Bards' magical manipulation of Ilum has been well- documented and extensively practiced, a newer and arguably more ",
                        "groundbreaking approach has emerged, the scientific manipulation of Ilum. This field, still in its infancy, offers exciting possibilities for those who wish to go beyond the traditional Bardic methods and gain ",
                        "precise control over Ilum on a molecular and atomic level. The Scientific Manipulation of Ilum  Though initially believed to be the exclusive domain of magic, Ilum can be manipulated through scientific techniques as well. ",
                        "By studying its properties and behavior, scientists have developed methods to alter Ilum without relying on musical performance. This manipulation is often more precise and calculated, offering an unprecedented level ",
                        "of control over the fundamental building blocks of reality. The most significant breakthrough in this field has been the creation of devices and tools capable of influencing Ilum directly. One such device is known as the Adagio Reducer. ",
                        "This invention allows scientists to alter the internal rhythm of Ilum particles, effectively slowing down or speeding up their movements. Since Ilum particles are created through rhythm, each one vibrates at a unique frequency, ",
                        "contributing to the overall harmony of the cosmos. By adjusting these frequencies, it is possible to manipulate the behavior of the particles in dramatic ways. The Adagio Reducer is an instrument designed to influence the tempo ",
                        "of an Ilum’s internal cosmic rhythm. By targeting specific Ilum particles, the Reducer can slow down or accelerate their internal movements, leading to a range of fascinating effects. When the internal rhythm of Ilum is ",
                        "decelerated, the particles become denser and more stable, which can result in physical objects becoming more solid and durable. On the other hand, accelerating the rhythm can lead to a loosening of the bonds between Ilum particles, making ",
                        "the object or entity more fluid or ethereal. In addition to affecting physical properties, the manipulation of Ilum’s rhythm can alter time and perception. Slowing down Ilum particles in a localized area has the effect of decelerating time ",
                        "itself, creating 'pockets' where time flows differently than in the surrounding environment. This has obvious applications in fields such as transportation, warfare, and medicine, where the ability to slow time could provide ",
                        "critical advantages. Additional Techniques for Ilum Manipulation Beyond Adagio Reducers, several other scientific methods for manipulating Ilum have been developed: ",
                        "Harmonic Splitters: These devices are capable of splitting a single Ilum particle into multiple fragments, each with a slightly different frequency.",
                        "This allows scientists to create new forms of matter or energy by recombining the fragmented particles in novel ways. This technique is particularly useful for",
                        "creating hybrid materials or synthesizing new elements that do not exist in nature. ",
                        "Ilum Synthesizers: Synthesizers allow scientists to artificially generate Ilum particles by simulating the cosmic rhythms that naturally give rise to them.",
                        "This has opened the door to creating new life forms, as the right combination of Ilum can be used to form organisms with specific traits. By controlling the melody of their creation, ",
                        "researchers can design beings with predetermined abilities and characteristics. ",
                        "Quantum Tuning Forks: This tool is used to 'tune' Ilum particles to specific frequencies, allowing for the precise alignment of particles within ",
                        "a field. By synchronizing the rhythms of multiple Ilum particles, scientists can create areas of intense magical or physical focus, leading to stronger enchantments or more potent magical fields. ",
                        "Conclusion; The study of Ilum, both magical and scientific, has unveiled a universe of possibilities that transcend our",
                        "current understanding of reality. As we learn to manipulate these particles with increasing precision, we must approach this power with caution. Ilum, the cosmic particle ",
                        "of music and life, is not just a tool for creation, it is the very essence of existence. ",
                        "Whether through Bardic music or scientific devices, the manipulation of Ilum will shape the future of the World of Do Re Mi. What remains to be seen is whether we can ",
                        "handle this power responsibly, or whether the pursuit of ultimate control will lead to the undoing of the harmonious universe we so carefully inhabit. ")
        ));

        // LAUREN'S JOURNAL 8
        books.add(createCustomWrittenBook(
                "Lauren's Journal",
                "Lauren",
                Arrays.asList("Day 1 - Something strange happened. I woke up with a headache. I'm in Cipton. A few hours ago, I was shot in the shoulder by a strange man. I was assigned to guard the door of the Evilian Headquarters. My shoulder barely hurts anymore, but ",
                        "my body... It seems like I'm near my old laboratory. Everything is in chaos. It looks like there was a massive earthquake. I'm lucky to have survived to report in this pocketbook. I found my laboratory. It was exposed to the surface by a huge ",
                        "crack in the cave. Some rooms are destroyed, and everything is a mess just like outside, fallen buildings, people running in panic, enormous cliffs suddenly appearing... I need to figure out what happened.  Day 2 - A day has passed. ",
                        "My shoulder started hurting again. I endured the pain and removed the lodged bullet with tweezers. I’ve got my bearings and organized my things. I realized the man who shot me took the replica of the Codex I had left out. Today, I’ll head to the ",
                        "city to see if I can find someone or something. I'm extremely worried about the situation.  Day 3 - I met a girl. Her name is Layla. Yes, the same Layla who defeated hundreds of soldiers and liberated countless nations from Evilian control. I ",
                        "remember seeing her briefly during the War; the adrenaline at that moment was so high I didn’t pay attention. I brought her to my lab. She seems scared and angry, and she kept talking about rescuing her brother... She decided not to ",
                        "stay. She was desperate to find him. I gave her a backpack with survival supplies. I’ll seriously research this event. The whole situation is terrifying. Imagine, reader, being taken to the other side of the map by a random ",
                        "beam of light, as if hundreds of earthquakes had destroyed your homeland.  Day 37 - A month has passed. I’m no longer in Cipton. Well, theoretically I am, but in reality, it's some sort of amalgamation of various islands and continents. I used ",
                        "an electromagnetic system to measure the ground’s vibrations. It’s constantly shifting... I found solid elements never seen before in Cipton. After much reading and research, it seems to come from the island 'Specthrus.' That’s exactly it; ",
                        "I’m in a dimensional knot, where several dimensional fabrics have been merged by someone or something. That’s why the earthquakes and destruction occurred. I’m sure this was orchestrated by some superior mind, such a feat ",
                        "deserves divine reverence! A few days after Layla’s departure, she returned to the lab. She said it was practically impossible to escape the deep crater we’re in. The ground was too unstable and could split at any moment.  Day 38 - ",
                        "Not all is lost, maybe... I’ve been thinking about how to reverse the chaos. I spent several days pondering a prototype of a “continent separator,” but I think it’s impossible. I’ve read about something like that ",
                        "in history books, but this case is different, it’s a quantum entanglement, like trying to separate purple playdough into blue and red parts... However, the most viable solution would be a machine capable of reversing everything! I’m ",
                        "talking about a time machine, capable of manipulating cosmic-temporal Ilums! This would be the greatest project of my life! I think Layla could be useful; she seems deeply shaken. If I present a solution to this chaos, ",
                        "maybe she’ll agree to help. I hate to admit it, but under current circumstances, I’m doomed to work in a team again. Debug, if it weren’t for you, I would’ve kicked the girl out long ago... Well, she doesn’t seem to know much about science, but after ",
                        "some persistence, she agreed to help. I asked her to read some books from the library and let me know if she found anything useful. In just a few days, she managed to find the original Codex that I’d hidden at the back of the shelf, very perceptive of her. ",
                        "Day 46 - A girl knocked on the lab door. Her name is Yolanda. I also saw her in the war. She was looking for Layla and asked for food and shelter. Another poor soul who survived on her own in this completely post- apocalyptic place. I let her in. She’s ",
                        "smart, and coincidentally, she’s not only a scientist but also specializes in Ilums and their temporal properties. Yolanda apparently owns another Codex. I wonder if this is fate or if my luck, which I’ve never had in life, is ",
                        "finally showing up all at once...  Day 82 - I still don’t fully understand what happened today. Things are getting weirder and weirder. While I was working on the machine with Yolanda, I heard a noise in the library. We both went to check, ",
                        "and... I’m still recovering from what happened... Several books in the library were spinning around Layla at high speed. Her eyes began to glow intensely. I went blind again. I heard voices and chants. Layla spoke strange words. She ",
                        "said she was dead and too powerful to live among us, things like that. I was really confused... After that, she disappeared, along with several books from my collection, including both Codexes. Why did this happen? Who is Layla really? A ",
                        "Goddess? Or perhaps the Devil? Well, at least I still have Yolanda to work with.  Day 97 - Maybe I’ve understood how time works in our universe. I’ll explain the conclusion I reached after seriously researching with ",
                        "Yoyo. There’s only one timeline. It moves forward at all times; it cannot be stopped. It has existed since the beginning of time. If we were to go back to the past, it wouldn’t be in the same timeline. That would create some kind of paradox. ",
                        "I’m not sure exactly what, maybe space-time would collide, maybe I’d create a hole in the cosmos, or perhaps a new timeline would grow from that modification in the past of my timeline. This last option is the most likely. Although ",
                        "confusing, I believe that going back to the past would create a new timeline separate from this one, growing from the change made in the past, not like a second world or dimension, but a form of space-time relation. Future researchers, use my ",
                        "genius only for good creations, don’t destroy your land as we did here. Day 203 - It's been a long time since the global catastrophe. The ground moves as if it’s alive. The crater is no longer a crater (I have no idea how this ",
                        "happened). We’re exposed to the surface again. We’ve discovered our colonizer, Tusz, that’s all we know. The same man who ruled over the Roda prison. I wonder what it’s like now... There are government agents and high- tech robots ",
                        "everywhere. We’re trying to keep the project as hidden as possible. Although they don’t seem that organized, trying to unite dozens of dimensions into one and maintaining control is utopian. Nobody must have warned him. It’s likely that there ",
                        "was a flaw in his plans. We need to go out to find more resources. I’ve run out of Adagsteel, which makes up the structure of the machine to support the manipulation of Ilums. This new ruler is ridiculous, I must say.  Day 381 - It’s done. My ",
                        "machine is finally complete! I can’t express my happiness through written words, but this is the achievement of my life! I’ve named it Bubble Ilurium. We tested it with a small apple. We don’t know if it worked, but the apple simply ",
                        "vanished, as if by magic. If all my work and calculations are correct, this object has gone to the past! This is madness! But it’s science! All we need now is a human test subject and probably a way to establish communication with ",
                        "this future traveler, so we don’t lose them in time. Yolanda doesn’t seem as excited as I am. On the contrary, she appears regretful, as if she’s broken a promise or something.  Day 411 - Okay, I don’t have time to write much. This is just ",
                        "a record of what’s going to happen now. Yoyo volunteered to debut the machine. It’s a huge responsibility. I initially refused, but I had to accept. We don’t have many options. We’re getting ready, and she’ll use the machine. ",
                        "It’s a big farewell. I confess I’ll miss her, just as I miss Debug. Yoyo revealed to me that she had sworn to herself never to meddle with temporal alterations on this scale again, which is why she can’t feel proud about it. I’m praying for ",
                        "everything to go well, but who am I praying to? I don’t even know. After Layla’s incident, I’m not sure if I can believe that disturbing scene came from a 'goddess of goodness' like Isabel.  Day 430 - That's it! Yoyo used the machine. ",
                        "She’s gone. It seems there were no side effects; the machine emitted smoke and beams of white light. The Bubble Ilurium spun at high speed, just like with the test apple. I hope she’s alright. I’ll try to communicate through the mechanism ",
                        "integrated into her staff. If it doesn’t work, I’ll start to worry, and to fear. Fear of the unknown nature we have just invaded. Day 612 - So much time has passed, I almost forgot about this diary. I’ve been busy searching for food. No response ",
                        "from Yoyo. I’m scared. I miss her. This government is getting worse, it’s truly a catastrophe. I haven’t left the lab for what must be months. I’m hiding in the library, and I’ve pushed the shelves to block off the main room. The sky ",
                        "outside is more purple and chaotic; it’s all I see through the crack. I no longer hear the footsteps of the government agents. It seems like everything is dark. I regret using an apple as a test subject. I don’t see the sun anymore. I see ",
                        "souls flying in and out of my refuge. I don’t know if they’re real or just in my mind. Yolanda, please respond. Day X - Months or years have passed; I’ve lost track of time. Still no response. I need to think, there must be a solution. I will ",
                        "use the machine. I need to find her. I need to satisfy my curiosity, and if this works, my life will be complete. It would be the project of my dreams. I’ll finally be recognized; I’ll be the savior. I need to prove my divine invention works. I ",
                        "need to find Yolanda. It’s been years since I’ve seen another human being. Cosmic and unconscious entities stare at me. Debug watches me from above the shelves. He stares at me, but I can’t look back at him. I don’t want to eat bugs anymore. This ",
                        "life... I can’t bear it. I can’t bear this. Day Y - I’m going to use the machine right now. Everyone will see, see how I’m the savior of the world. They’ll regret having humiliated me all my life. I’ll go back to the past myself, fix the ",
                        "dimensional- temporal fabric, take this notebook with me, write in it in the past, and one day return to the future. They’ll all worship me. They’ll see. I will destroy Evil Pipe. I will destroy the Evilians. The Bubble Ilurium will be glorified. ",
                        "Isabel will bow before me. Lokhran bowed before me. I’m lying in the machine now. I’m going to turn it on. ",
                        "",
                        "",
                        "",
                        "",
                        "")
        ));

        // MUSICISM BOOK 9
        books.add(createCustomWrittenBook(
                "Key Tenets of Musicism",
                "Vivianne",
                Arrays.asList("Musicism, often referred to as Dorrémism, is the most widely practiced religion on the Island of Do Re Mi, centered around the worship of Isabel, the Goddess of Music. The origins of this faith are rooted in the three Codex, ancient and ",
                        "mysterious texts written in an unknown language, containing hidden powers. These texts are the subject of great interest and study by scientists and historians across the world of Do Re Mi. Unlike Rokirism, which seeks to bring chaos and disrupt ",
                        "order, Musicism upholds harmony, order, and balance through music and creation.",
                        "Creation and Universal Harmony: Musicism teaches that Isabel created the universe through sound, using music as her instrument for creation and order.",
                        "From the smallest creature to the largest celestial systems, everything is part of a cosmic symphony orchestrated by Isabel. Maintaining harmony is seen as vital in all things.",
                        "Respect for the Natural Order: Followers of Musicism believe in a natural order that reflects the will of Isabel.",
                        "This order is sustained through balance between living beings, elements, and cosmic forces. Preserving this order is essential to maintaining harmony in the universe.",
                        "The Power of Music and Creation: To the Musicists, music is not merely a form of expression but the essence of creation itself. Music possesses the power to create, heal, unite, and guide. Every being created ",
                        "by Isabel carries its own melody, and it is the duty of Musicists to listen, respect, and harmonize with these melodies. ",
                        "Pursuit of Enlightenment and Wisdom: Musicists seek enlightenment by aligning themselves with Isabel’s music and the universe. ",
                        "This path involves deep study of the laws of music and the cosmos, as well as practicing good deeds and fostering peace and order. ",
                        "Protection of Life and Creation: The preservation of life in all its forms is a core principle. All beings are seen as part of",
                        "Isabel’s creation and must be treated with respect and dignity. Violence and destruction are considered contrary to her will. ",
                        "The Struggle Against Evil and Chaos: While Musicists acknowledge the existence of evil, personified by Lokhran, they view it as a disturbance of the balance",
                        "that must be restrained. Isabel’s song is a means of maintaining this balance, preventing chaos from overtaking the universe.",
                        "Celebration of Life and Creation through Music: Musicists frequently gather to celebrate life, creation, and the presence of Isabel",
                        "through music festivals, dancing, and singing. These celebrations reinforce the harmony between beings and their connection to the cosmos."
                )
        ));

        //Adagsteel book 10
        books.add(createCustomWrittenBook(
                "The Physics of Adagsteel",
                "Felipson Amadeo",
                Arrays.asList("Introduction: This study aims to highlight the main physical and chemical characteristics of the most widely used ore in the world, Adagsteel and its variants.",
                        "Adagsteel is a unique metallic material found across the Do Re Mi World, with notable reserves located in places such as the Island of Do Re Mi, Surreal, and Cipton. While it bears a superficial resemblance to iron, Adagsteel is distinct in several",
                        "critical ways, both in its physical characteristics and in its uses. Its supreme durability and versatility, especially when alloyed to form Hardagsteel, have made it an invaluable resource in the construction of infrastructure and weaponry. This",
                        "study aims to examine the chemical and physical properties of Adagsteel and Hardagsteel, their forging processes, and their applications in various industries.",
                        "1. Physical Characteristics: Adagsteel exhibits a dark gray coloration, nearing black, which immediately sets it apart from iron. Though its appearance may deceive the untrained eye into thinking it is an iron variant, its",
                        "darker hue indicates its unique chemical makeup. The material is notably malleable, allowing it to be easily shaped and forged, though it lacks significant tensile strength, being less tenacious than iron. However, it compensates for",
                        "this with impressive magnetic properties and corrosion resistance, making it a choice material for environments where other metals might rust.",
                        "2. Chemical Structure: Adagsteel’s composition is believed to involve an iron-based core structure with additional elemental impurities that contribute to its darker color and magnetic characteristics.",
                        "These impurities, although not fully understood, are crucial in providing the material its resistance to oxidation, making Adagsteel stainless under most atmospheric conditions. This renders it ideal for the creation of",
                        "weaponry, particularly blades, which benefit from durability without the risk of rust or degradation over time.",
                        "3. Applications: Adagsteel is widely used in the construction of infrastructure—be it in bridges, gates, or foundational supports—owing to its resistance to environmental wear. Its magnetic properties also lend themselves to",
                        "engineering innovations where magnetism is necessary for machinery or complex devices. Weapon manufacturers prize Adagsteel for use in blades, as it combines the sharpness of steel with the longevity of a non-corrosive",
                        "metal, enhancing combat efficiency in various climates.",
                        "The forging of Hardagsteel, however, requires a much more complicated metallurgical process, which will be explained in the second volume of this study.")
        ));

        //Pirates Book 11
        books.add(createCustomWrittenBook(
                "The Sea and The Chaos",
                "Hycarus, the Oracle",
                Arrays.asList("The Harmonic Seas are a vast and tranquil body of water that stretches across the entirety of the Do Re Mi World. This ocean, renowned for its constant calm, emits a gentle, continuous melody that resonates through its",
                        "crystal-clear waters, creating an almost hypnotic atmosphere for those sailing its waves. The melodies that rise from the Harmonic Seas are a blend of harmonious notes that not only soothe but also guide travelers, making the ocean feel like an",
                        "immense musical instrument. However, despite its apparent serenity, the Harmonic Seas are also home to infamous pirates who exploit the confusion brought by musical storms to conceal their activities. These pirates are known",
                        "for their cunning and unpredictability, using the sea’s ever-changing music to surprise and ambush their prey. Given the sheer vastness of these waters, the seas are heavily trafficked, with a strong presence of pirates and sailors",
                        "alike throughout the world. It is nearly impossible to sail these seas without spotting another vessel on the horizon. Pirates are driven by their own ambitions, often clashing with the governments of the states bordering these waters in a",
                        "continuous struggle for control.  Among the most notorious pirates are:",
                        "Tero the Trident, captain of the massive ship Dorelena, which has now become a major gathering place for pirates. It serves as a black market, famously known as 'The Den.'",
                        "The Den is infamous for its black-market dealings, where anything from stolen artifacts to rare musical instruments imbued with magic can be bought and sold.",
                        "Pirate Lima, who is in constant battle with the crew of Morguilho. Lima commands the brig Citrus and often works in favor of official requests to hunt down other leaders or political organizations.",
                        "The Citrus is known for its speed and agility, making it difficult for even the most skilled naval captains to pursue.",
                        "Morguilho's Crew, known as the 'Rock Pirates' and led by the infamous Captain Pedro, are a group of bold and chaotic adventurers in the lands of Do Re Mi. They are not interested in wealth or power but rather in sowing chaos and disrupting the",
                        "natural order of things. Also notorious for causing havoc at important events, and their members are considered 'mad' or insane due to the constant chaos they spread, combined with their bizarre and energetic personalities.",
                        "The crew consists of Pedro, his wife Jane, 'The Artist of Death', their daughter Lucy, 'Shimmering Saber', Ruffus, 'The Titan Pachyderm', Clius, 'The Mad Goblin', and finally, the infamous 'Batcher Brothers', Pepe and Paco.",
                        "There are countless stories circulating about the dangerous adventures of the Rock Pirates."
                )
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
