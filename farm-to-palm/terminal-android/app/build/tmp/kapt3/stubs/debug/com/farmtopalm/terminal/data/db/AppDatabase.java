package com.farmtopalm.terminal.data.db;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&\u00a8\u0006\u0010"}, d2 = {"Lcom/farmtopalm/terminal/data/db/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "attendanceEventDao", "Lcom/farmtopalm/terminal/data/db/dao/AttendanceEventDao;", "mealEventDao", "Lcom/farmtopalm/terminal/data/db/dao/MealEventDao;", "nfcCardDao", "Lcom/farmtopalm/terminal/data/db/dao/NfcCardDao;", "palmTemplateDao", "Lcom/farmtopalm/terminal/data/db/dao/PalmTemplateDao;", "studentDao", "Lcom/farmtopalm/terminal/data/db/dao/StudentDao;", "terminalConfigDao", "Lcom/farmtopalm/terminal/data/db/dao/TerminalConfigDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.farmtopalm.terminal.data.db.entities.StudentEntity.class, com.farmtopalm.terminal.data.db.entities.PalmTemplateEntity.class, com.farmtopalm.terminal.data.db.entities.NfcCardEntity.class, com.farmtopalm.terminal.data.db.entities.AttendanceEventEntity.class, com.farmtopalm.terminal.data.db.entities.MealEventEntity.class, com.farmtopalm.terminal.data.db.entities.TerminalConfigEntity.class}, version = 4, exportSchema = false)
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.farmtopalm.terminal.data.db.AppDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final com.farmtopalm.terminal.data.db.AppDatabase.Companion Companion = null;
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.farmtopalm.terminal.data.db.dao.StudentDao studentDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.farmtopalm.terminal.data.db.dao.PalmTemplateDao palmTemplateDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.farmtopalm.terminal.data.db.dao.NfcCardDao nfcCardDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.farmtopalm.terminal.data.db.dao.AttendanceEventDao attendanceEventDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.farmtopalm.terminal.data.db.dao.MealEventDao mealEventDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.farmtopalm.terminal.data.db.dao.TerminalConfigDao terminalConfigDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/farmtopalm/terminal/data/db/AppDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/farmtopalm/terminal/data/db/AppDatabase;", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.farmtopalm.terminal.data.db.AppDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}