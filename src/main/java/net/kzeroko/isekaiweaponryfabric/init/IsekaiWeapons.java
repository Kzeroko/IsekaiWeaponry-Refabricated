package net.kzeroko.isekaiweaponryfabric.init;

import net.kzeroko.isekaiweaponryfabric.IsekaiUtils;
import net.kzeroko.isekaiweaponryfabric.IsekaiweaponryFabric;
import net.kzeroko.isekaiweaponryfabric.enums.IsekaiMaterials;
import net.kzeroko.isekaiweaponryfabric.item.custom.*;
import net.minecraft.item.*;
import net.minecraft.util.Rarity;

public class IsekaiWeapons {
    public static final ItemGroup WEAPONS;
    public static ToolItem KANNAS_DEVILSPEAR;
    public static ToolItem KISARAS_DEVILSWORD;
    public static ToolItem PAN_DORAL;
    public static ToolItem PAN_DORAR;
    public static ToolItem SER_VERESTA;
    public static ToolItem RAZOR_EDGE;
    public static ToolItem SHADOWOF_YGGDRASIL;
    public static ToolItem SPUIT_LANCE;
    public static ToolItem CHARONS_GUIDANCE;
    public static ToolItem TOHKAS_SANDALPHON;
    public static ToolItem HF_MURAMASA;
    public static ToolItem LAMBENT_LIGHT;
    public static ToolItem PROTOTYPE_HOLYSWORD;
    public static ToolItem CRESCENT_ROSE;
    public static ToolItem MONADO_II;
    public static ToolItem ORIGAMI_SETSUGEKKA;
    public static ToolItem ORIGAMI_MOMIJI;
    public static ToolItem ORIGAMI_KATENROUGETSUAMAHISA;
    public String[] weapons = new String[]
            {"kannas_devilspear", "kisaras_devilsword", "pan_doral", "pan_dorar", "ser_veresta", "razor_edge", "shadowof_yggdrasil", "spuit_lance", "charons_guidance", "tohkas_sandalphon", "hf_muramasa", "lambent_light", "prototype_holysword", "crescent_rose", "monado_ii", "origami_setsugekka", "origami_momiji", "origami_katenrougetsuamahisa"};

    public IsekaiWeapons() {
    }

    public static void init() {
        IsekaiUtils.registerItem(KANNAS_DEVILSPEAR, "kannas_devilspear");
        IsekaiUtils.registerItem(KISARAS_DEVILSWORD, "kisaras_devilsword");
        IsekaiUtils.registerItem(PAN_DORAL, "pan_doral");
        IsekaiUtils.registerItem(PAN_DORAR, "pan_dorar");
        IsekaiUtils.registerItem(SER_VERESTA, "ser_veresta");
        IsekaiUtils.registerItem(RAZOR_EDGE, "razor_edge");
        IsekaiUtils.registerItem(SHADOWOF_YGGDRASIL, "shadowof_yggdrasil");
        IsekaiUtils.registerItem(SPUIT_LANCE, "spuit_lance");
        IsekaiUtils.registerItem(CHARONS_GUIDANCE, "charons_guidance");
        IsekaiUtils.registerItem(TOHKAS_SANDALPHON, "tohkas_sandalphon");
        IsekaiUtils.registerItem(HF_MURAMASA, "hf_muramasa");
        IsekaiUtils.registerItem(LAMBENT_LIGHT, "lambent_light");
        IsekaiUtils.registerItem(PROTOTYPE_HOLYSWORD, "prototype_holysword");
        IsekaiUtils.registerItem(CRESCENT_ROSE, "crescent_rose");
        IsekaiUtils.registerItem(MONADO_II, "monado_ii");
        IsekaiUtils.registerItem(ORIGAMI_SETSUGEKKA, "origami_setsugekka");
        IsekaiUtils.registerItem(ORIGAMI_MOMIJI, "origami_momiji");
        IsekaiUtils.registerItem(ORIGAMI_KATENROUGETSUAMAHISA, "origami_katenrougetsuamahisa");
    }

    static {
        WEAPONS = IsekaiweaponryFabric.WEAPONS;
        // Engage Kiss
        KANNAS_DEVILSPEAR = new KannasDevilspear(IsekaiMaterials.ENGAGEKISS,-2.4F, (new Item.Settings()).group(WEAPONS).rarity(Rarity.EPIC).fireproof());
        KISARAS_DEVILSWORD = new KisarasDevilsword(IsekaiMaterials.ENGAGEKISS,-2.4F, (new Item.Settings()).group(WEAPONS).rarity(Rarity.EPIC).fireproof());
        // Gakusen Toshi Asterisk
        PAN_DORAL = new PanDoraL(IsekaiMaterials.ASTERISK, -2.5F, (new Item.Settings()).group(WEAPONS).rarity(Rarity.EPIC).fireproof());
        PAN_DORAR = new PanDoraR(IsekaiMaterials.ASTERISK,-2.5F, (new Item.Settings()).group(WEAPONS).rarity(Rarity.EPIC).fireproof());
        SER_VERESTA = new SerVeresta(IsekaiMaterials.ASTERISK,-2.6F, (new Item.Settings()).group(WEAPONS).rarity(Rarity.EPIC).fireproof());
        // Overlord
        RAZOR_EDGE = new RazorEdge(IsekaiMaterials.OVERLORD,-2.5F, (new Item.Settings()).group(WEAPONS).rarity(Rarity.EPIC).fireproof());
        SHADOWOF_YGGDRASIL = new ShadowofYggdrasil(IsekaiMaterials.OVERLORD,-2.8F, (new Item.Settings()).group(WEAPONS).rarity(Rarity.EPIC).fireproof());
        SPUIT_LANCE = new SpuitLance(IsekaiMaterials.OVERLORD,-2.4F, (new Item.Settings()).group(WEAPONS).rarity(Rarity.EPIC).fireproof());
        CHARONS_GUIDANCE = new CharonsGuidance(IsekaiMaterials.OVERLORD,-2.5F, (new Item.Settings()).group(WEAPONS).rarity(Rarity.EPIC).fireproof());
        // Date A Live
        TOHKAS_SANDALPHON = new TohkasSandalphon(IsekaiMaterials.DAL,-2.6F, (new Item.Settings()).group(WEAPONS).rarity(Rarity.EPIC).fireproof());
        // Metal Gear RR
        HF_MURAMASA = new HfMuramasa(IsekaiMaterials.MGRR,-2.1F, (new Item.Settings()).group(WEAPONS).rarity(Rarity.EPIC).fireproof());
        // Sword Art Online
        LAMBENT_LIGHT = new LambentLight(IsekaiMaterials.SAO,-2.1F, (new Item.Settings()).group(WEAPONS).rarity(Rarity.EPIC).fireproof());
        // The Eminence in Shadow
        PROTOTYPE_HOLYSWORD = new PrototypeHolysword(IsekaiMaterials.SHADOW,-2.5F, (new Item.Settings()).group(WEAPONS).rarity(Rarity.EPIC).fireproof());
        // RWBY
        CRESCENT_ROSE = new CrescentRose(IsekaiMaterials.RWBY,-2.6F, (new Item.Settings()).group(WEAPONS).rarity(Rarity.EPIC).fireproof());
        // Xenoblade Chronicles
        MONADO_II = new MonadoII(IsekaiMaterials.XENOBLADE,-2.4F, (new Item.Settings()).group(WEAPONS).rarity(Rarity.EPIC).fireproof());
        // ORIGAMI
        ORIGAMI_SETSUGEKKA = new OrigamiSetsugekka(IsekaiMaterials.ORIGAMI,-2.3F, (new Item.Settings()).group(WEAPONS).rarity(Rarity.EPIC).fireproof());
        ORIGAMI_MOMIJI = new OrigamiMomiji(IsekaiMaterials.ORIGAMI,-2.1F, (new Item.Settings()).group(WEAPONS).rarity(Rarity.EPIC).fireproof());
        ORIGAMI_KATENROUGETSUAMAHISA = new OrigamiKatenRougetsuAmahisa(IsekaiMaterials.ORIGAMI,-2.2F, (new Item.Settings()).group(WEAPONS).rarity(Rarity.EPIC).fireproof());
    }
}

