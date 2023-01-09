package net.kzeroko.isekaiweaponryfabric.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.kzeroko.isekaiweaponryfabric.IsekaiweaponryFabric;

@Config(name = IsekaiweaponryFabric.MOD_ID)
public final class IsekaiConfig implements ConfigData {

    @ConfigEntry.Gui.Tooltip
    public int demonspearDamage = 17;

    @ConfigEntry.Gui.Tooltip
    public float demonspearExtraDamage = 6.0F;

    @ConfigEntry.Gui.Tooltip
    public int demonswordDamage = 18;

    @ConfigEntry.Gui.Tooltip
    public float demonswordExtraDamage = 5.0F;

    @ConfigEntry.Gui.Tooltip
    public float demonswordExtraHeal = 2.5F;

    @ConfigEntry.Gui.Tooltip
    public int pandoralDamage = 15;

    @ConfigEntry.Gui.Tooltip
    public int pandorarDamage = 15;

    @ConfigEntry.Gui.Tooltip
    public int serverestaDamage = 18;

    @ConfigEntry.Gui.Tooltip
    public int razoredgeDamage = 13;

    @ConfigEntry.Gui.Tooltip
    public int shadowofyggdrasilDamage = 25;

    @ConfigEntry.Gui.Tooltip
    public int spuitlanceDamage = 27;

    @ConfigEntry.Gui.Tooltip
    public float spuitlanceExtraDamage = 8.0F;

    // @ConfigEntry.BoundedDiscrete(min = 0, max = 100)
    @ConfigEntry.Gui.Tooltip
    public float spuitlanceHealPortion = 20.0F;

    @ConfigEntry.Gui.Tooltip
    public int charonsguidanceDamage = 22;

    @ConfigEntry.Gui.Tooltip
    public int sandalphonDamage = 21;

    @ConfigEntry.Gui.Tooltip
    public int hfmuramasaDamage = 16;

    @ConfigEntry.Gui.Tooltip
    public int lambentlightDamage = 13;

    @ConfigEntry.Gui.Tooltip
    public int prototypeholyswordDamage = 18;

    @ConfigEntry.Gui.Tooltip
    public int crescentroseDamage = 14;

    @ConfigEntry.Gui.Tooltip
    public double crescentroseProjectileDamage = 20;

    @ConfigEntry.Gui.Tooltip
    public int monadoiiDamage = 22;

    @ConfigEntry.Gui.Tooltip
    public int origamisetsugekkaDamage = 8;

    @ConfigEntry.Gui.Tooltip
    public int origamimomijiDamage = 12;

    @ConfigEntry.Gui.Tooltip
    public int origamikatenrougetsuamahisaDamage = 14;

    @ConfigEntry.Gui.Tooltip
    public double donnerandschlagProjectileDamage = 25;

    @ConfigEntry.Gui.Tooltip
    public int druckenDamage = 23;
}

