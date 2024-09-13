package net.doremista.sound;

import net.doremista.Doremitales;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent AEONFLUTEPLAY = registerSoundEvent("aeonfluteplay");

    public static final SoundEvent EVELYNTHEME = registerSoundEvent("evelyntheme");

    public static final SoundEvent BATCHERSTHEME = registerSoundEvent("batcherstheme");

    public static final SoundEvent ELEPHASTICTHEME = registerSoundEvent("elephastictheme");

    public static final SoundEvent RUBBERCHICKEN_DEATH = registerSoundEvent("rubberchicken_death");
    public static final SoundEvent RUBBERCHICKEN_HURT = registerSoundEvent("rubberchicken_hurt");
    public static final SoundEvent RUBBERCHICKEN_AMBIENT = registerSoundEvent("rubberchicken_ambient");
    public static final SoundEvent RUBBERCHICKEN_ATTACK = registerSoundEvent("rubberchicken_attack");
    public static final SoundEvent RUBBERCHICKEN_JUMPSCARE = registerSoundEvent("rubberchicken_jumpscare");


    public static final SoundEvent RUBBERTRUMPET1 = registerSoundEvent("rubbertrumpet1");
    public static final SoundEvent RUBBERTRUMPET2 = registerSoundEvent("rubbertrumpet2");
    public static final SoundEvent RUBBERTRUMPET3 = registerSoundEvent("rubbertrumpet3");
    public static final SoundEvent RUBBERTRUMPET4 = registerSoundEvent("rubbertrumpet4");
    public static final SoundEvent RUBBERTRUMPET5 = registerSoundEvent("rubbertrumpet5");


    private static SoundEvent registerSoundEvent(String name){
        Identifier id = new Identifier(Doremitales.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds(){
        Doremitales.LOGGER.info("Registering sounds for DoremiTales");
    }
}
