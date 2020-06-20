package WIELKIPLUGIN;

public class Main implements JavaPlugin {
    public static YamlConfiguration LANG;
    public static File LANG_FILE;
  
  public void onEnable() {
    public void loadLang() {
    File lang = new File(getDataFolder(), "lang.yml");
    if (!lang.exists()) {
        try {
            getDataFolder().mkdir();
            lang.createNewFile();
            InputStream defConfigStream = this.getResource("lang.yml");
            if (defConfigStream != null) {
                YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
                defConfig.save(lang);
                Lang.setFile(defConfig);
                return defConfig;
            }
        } catch(IOException e) {
            e.printStackTrace(); // So they notice
            log.severe("Nie mozna utworzyc pliku lang.yml.");
            log.severe("Wylaczanie");
            this.setEnabled(false); // Without it loaded, we can't send them messages
        }
    }
    YamlConfiguration conf = YamlConfiguration.loadConfiguration(lang);
    for(Lang item:Lang.values()) {
        if (conf.getString(item.getPath()) == null) {
            conf.set(item.getPath(), item.getDefault());
        }
    }
    Lang.setFile(conf);
    MainClass.LANG = conf;
    MainClass.LANG_FILE = lang;
    try {
        conf.save(getLangFile());
    } catch(IOException e) {
        log.log(Level.WARNING, "Nie mozna zapisac lang.yml.");
        log.log(Level.WARNING, "Wylaczanie");
        e.printStackTrace();
      this.setEnabled(false); // Without it loaded, we can't send them messages
    }
    }
}

public YamlConfiguration getLang() {
    return LANG;
}

public File getLangFile() {
    return LANG_FILE;
}

  }
