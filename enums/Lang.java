/** Źródło: https://bukkit.org/threads/language-files.149837/ */


package WIELKIPLUGIN.enums;
 
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
 
public enum Lang {
    TITLE("plugin-title", "&4WielkiPlugin:"),
    HELPCMD("help-command", "/** dodajcie własną wiadomość */"),
    INVALID_ARGS("invalid-args", "&cBłąd, sprawdź czy podałeś odpowiednią ilość argumentów!"),
    PLAYER_ONLY("player-only", "Przepraszamy konsolo!"),
    NO_PERMS("no-permissions", "&cNie posiadasz uprawnien do tej komendy");
 
    private String path;
    private String def;
    private static YamlConfiguration LANG;
 

    Lang(String path, String start) {
        this.path = path;
        this.def = start;
    }
 

    public static void setFile(YamlConfiguration config) {
        LANG = config;
    }
 
    @Override
    public String toString() {
        if (this == TITLE)
            return ChatColor.translateAlternateColorCodes('&', LANG.getString(this.path, def)) + " ";
        return ChatColor.translateAlternateColorCodes('&', LANG.getString(this.path, def));
    }
 

    public String getDefault() {
        return this.def;
    }
 

    public String getPath() {
        return this.path;
    }
}
 
