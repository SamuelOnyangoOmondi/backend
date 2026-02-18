package com.farmtopalm.terminal.data.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.farmtopalm.terminal.data.db.dao.AttendanceEventDao;
import com.farmtopalm.terminal.data.db.dao.AttendanceEventDao_Impl;
import com.farmtopalm.terminal.data.db.dao.MealEventDao;
import com.farmtopalm.terminal.data.db.dao.MealEventDao_Impl;
import com.farmtopalm.terminal.data.db.dao.NfcCardDao;
import com.farmtopalm.terminal.data.db.dao.NfcCardDao_Impl;
import com.farmtopalm.terminal.data.db.dao.PalmTemplateDao;
import com.farmtopalm.terminal.data.db.dao.PalmTemplateDao_Impl;
import com.farmtopalm.terminal.data.db.dao.StudentDao;
import com.farmtopalm.terminal.data.db.dao.StudentDao_Impl;
import com.farmtopalm.terminal.data.db.dao.TerminalConfigDao;
import com.farmtopalm.terminal.data.db.dao.TerminalConfigDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile StudentDao _studentDao;

  private volatile PalmTemplateDao _palmTemplateDao;

  private volatile NfcCardDao _nfcCardDao;

  private volatile AttendanceEventDao _attendanceEventDao;

  private volatile MealEventDao _mealEventDao;

  private volatile TerminalConfigDao _terminalConfigDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(4) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `students` (`id` TEXT NOT NULL, `externalId` TEXT NOT NULL, `name` TEXT NOT NULL, `schoolId` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `palm_templates` (`id` TEXT NOT NULL, `studentId` TEXT NOT NULL, `hand` TEXT NOT NULL, `rgbFeatureEnc` BLOB NOT NULL, `irFeatureEnc` BLOB NOT NULL, `quality` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, `streamType` TEXT, `rgbModelHash` TEXT, `irModelHash` TEXT, `sdkTemplateId` TEXT, PRIMARY KEY(`id`), FOREIGN KEY(`studentId`) REFERENCES `students`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_palm_templates_studentId` ON `palm_templates` (`studentId`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_palm_templates_sdkTemplateId` ON `palm_templates` (`sdkTemplateId`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `nfc_cards` (`id` TEXT NOT NULL, `studentId` TEXT NOT NULL, `uid` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`studentId`) REFERENCES `students`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_nfc_cards_uid` ON `nfc_cards` (`uid`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_nfc_cards_studentId` ON `nfc_cards` (`studentId`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `attendance_events` (`id` TEXT NOT NULL, `studentId` TEXT NOT NULL, `terminalId` TEXT NOT NULL, `schoolId` TEXT NOT NULL, `ts` INTEGER NOT NULL, `confidence` REAL NOT NULL, `synced` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_attendance_events_synced` ON `attendance_events` (`synced`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_attendance_events_terminalId` ON `attendance_events` (`terminalId`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_attendance_events_ts` ON `attendance_events` (`ts`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `meal_events` (`id` TEXT NOT NULL, `studentId` TEXT NOT NULL, `terminalId` TEXT NOT NULL, `schoolId` TEXT NOT NULL, `ts` INTEGER NOT NULL, `method` TEXT NOT NULL, `synced` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_meal_events_synced` ON `meal_events` (`synced`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_meal_events_terminalId` ON `meal_events` (`terminalId`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_meal_events_ts` ON `meal_events` (`ts`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `terminal_config` (`id` INTEGER NOT NULL, `terminalId` TEXT NOT NULL, `schoolId` TEXT NOT NULL, `apiBaseUrl` TEXT NOT NULL, `tokenEnc` BLOB NOT NULL, `activatedAt` INTEGER NOT NULL, `lastHeartbeatAt` INTEGER, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '041e219166c0b65284bfed3c655a6b0d')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `students`");
        db.execSQL("DROP TABLE IF EXISTS `palm_templates`");
        db.execSQL("DROP TABLE IF EXISTS `nfc_cards`");
        db.execSQL("DROP TABLE IF EXISTS `attendance_events`");
        db.execSQL("DROP TABLE IF EXISTS `meal_events`");
        db.execSQL("DROP TABLE IF EXISTS `terminal_config`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsStudents = new HashMap<String, TableInfo.Column>(6);
        _columnsStudents.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudents.put("externalId", new TableInfo.Column("externalId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudents.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudents.put("schoolId", new TableInfo.Column("schoolId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudents.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudents.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStudents = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStudents = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStudents = new TableInfo("students", _columnsStudents, _foreignKeysStudents, _indicesStudents);
        final TableInfo _existingStudents = TableInfo.read(db, "students");
        if (!_infoStudents.equals(_existingStudents)) {
          return new RoomOpenHelper.ValidationResult(false, "students(com.farmtopalm.terminal.data.db.entities.StudentEntity).\n"
                  + " Expected:\n" + _infoStudents + "\n"
                  + " Found:\n" + _existingStudents);
        }
        final HashMap<String, TableInfo.Column> _columnsPalmTemplates = new HashMap<String, TableInfo.Column>(11);
        _columnsPalmTemplates.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPalmTemplates.put("studentId", new TableInfo.Column("studentId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPalmTemplates.put("hand", new TableInfo.Column("hand", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPalmTemplates.put("rgbFeatureEnc", new TableInfo.Column("rgbFeatureEnc", "BLOB", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPalmTemplates.put("irFeatureEnc", new TableInfo.Column("irFeatureEnc", "BLOB", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPalmTemplates.put("quality", new TableInfo.Column("quality", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPalmTemplates.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPalmTemplates.put("streamType", new TableInfo.Column("streamType", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPalmTemplates.put("rgbModelHash", new TableInfo.Column("rgbModelHash", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPalmTemplates.put("irModelHash", new TableInfo.Column("irModelHash", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPalmTemplates.put("sdkTemplateId", new TableInfo.Column("sdkTemplateId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPalmTemplates = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysPalmTemplates.add(new TableInfo.ForeignKey("students", "CASCADE", "NO ACTION", Arrays.asList("studentId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesPalmTemplates = new HashSet<TableInfo.Index>(2);
        _indicesPalmTemplates.add(new TableInfo.Index("index_palm_templates_studentId", false, Arrays.asList("studentId"), Arrays.asList("ASC")));
        _indicesPalmTemplates.add(new TableInfo.Index("index_palm_templates_sdkTemplateId", false, Arrays.asList("sdkTemplateId"), Arrays.asList("ASC")));
        final TableInfo _infoPalmTemplates = new TableInfo("palm_templates", _columnsPalmTemplates, _foreignKeysPalmTemplates, _indicesPalmTemplates);
        final TableInfo _existingPalmTemplates = TableInfo.read(db, "palm_templates");
        if (!_infoPalmTemplates.equals(_existingPalmTemplates)) {
          return new RoomOpenHelper.ValidationResult(false, "palm_templates(com.farmtopalm.terminal.data.db.entities.PalmTemplateEntity).\n"
                  + " Expected:\n" + _infoPalmTemplates + "\n"
                  + " Found:\n" + _existingPalmTemplates);
        }
        final HashMap<String, TableInfo.Column> _columnsNfcCards = new HashMap<String, TableInfo.Column>(4);
        _columnsNfcCards.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNfcCards.put("studentId", new TableInfo.Column("studentId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNfcCards.put("uid", new TableInfo.Column("uid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNfcCards.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNfcCards = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysNfcCards.add(new TableInfo.ForeignKey("students", "CASCADE", "NO ACTION", Arrays.asList("studentId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesNfcCards = new HashSet<TableInfo.Index>(2);
        _indicesNfcCards.add(new TableInfo.Index("index_nfc_cards_uid", false, Arrays.asList("uid"), Arrays.asList("ASC")));
        _indicesNfcCards.add(new TableInfo.Index("index_nfc_cards_studentId", false, Arrays.asList("studentId"), Arrays.asList("ASC")));
        final TableInfo _infoNfcCards = new TableInfo("nfc_cards", _columnsNfcCards, _foreignKeysNfcCards, _indicesNfcCards);
        final TableInfo _existingNfcCards = TableInfo.read(db, "nfc_cards");
        if (!_infoNfcCards.equals(_existingNfcCards)) {
          return new RoomOpenHelper.ValidationResult(false, "nfc_cards(com.farmtopalm.terminal.data.db.entities.NfcCardEntity).\n"
                  + " Expected:\n" + _infoNfcCards + "\n"
                  + " Found:\n" + _existingNfcCards);
        }
        final HashMap<String, TableInfo.Column> _columnsAttendanceEvents = new HashMap<String, TableInfo.Column>(8);
        _columnsAttendanceEvents.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceEvents.put("studentId", new TableInfo.Column("studentId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceEvents.put("terminalId", new TableInfo.Column("terminalId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceEvents.put("schoolId", new TableInfo.Column("schoolId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceEvents.put("ts", new TableInfo.Column("ts", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceEvents.put("confidence", new TableInfo.Column("confidence", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceEvents.put("synced", new TableInfo.Column("synced", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceEvents.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAttendanceEvents = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAttendanceEvents = new HashSet<TableInfo.Index>(3);
        _indicesAttendanceEvents.add(new TableInfo.Index("index_attendance_events_synced", false, Arrays.asList("synced"), Arrays.asList("ASC")));
        _indicesAttendanceEvents.add(new TableInfo.Index("index_attendance_events_terminalId", false, Arrays.asList("terminalId"), Arrays.asList("ASC")));
        _indicesAttendanceEvents.add(new TableInfo.Index("index_attendance_events_ts", false, Arrays.asList("ts"), Arrays.asList("ASC")));
        final TableInfo _infoAttendanceEvents = new TableInfo("attendance_events", _columnsAttendanceEvents, _foreignKeysAttendanceEvents, _indicesAttendanceEvents);
        final TableInfo _existingAttendanceEvents = TableInfo.read(db, "attendance_events");
        if (!_infoAttendanceEvents.equals(_existingAttendanceEvents)) {
          return new RoomOpenHelper.ValidationResult(false, "attendance_events(com.farmtopalm.terminal.data.db.entities.AttendanceEventEntity).\n"
                  + " Expected:\n" + _infoAttendanceEvents + "\n"
                  + " Found:\n" + _existingAttendanceEvents);
        }
        final HashMap<String, TableInfo.Column> _columnsMealEvents = new HashMap<String, TableInfo.Column>(8);
        _columnsMealEvents.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealEvents.put("studentId", new TableInfo.Column("studentId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealEvents.put("terminalId", new TableInfo.Column("terminalId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealEvents.put("schoolId", new TableInfo.Column("schoolId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealEvents.put("ts", new TableInfo.Column("ts", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealEvents.put("method", new TableInfo.Column("method", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealEvents.put("synced", new TableInfo.Column("synced", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealEvents.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMealEvents = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMealEvents = new HashSet<TableInfo.Index>(3);
        _indicesMealEvents.add(new TableInfo.Index("index_meal_events_synced", false, Arrays.asList("synced"), Arrays.asList("ASC")));
        _indicesMealEvents.add(new TableInfo.Index("index_meal_events_terminalId", false, Arrays.asList("terminalId"), Arrays.asList("ASC")));
        _indicesMealEvents.add(new TableInfo.Index("index_meal_events_ts", false, Arrays.asList("ts"), Arrays.asList("ASC")));
        final TableInfo _infoMealEvents = new TableInfo("meal_events", _columnsMealEvents, _foreignKeysMealEvents, _indicesMealEvents);
        final TableInfo _existingMealEvents = TableInfo.read(db, "meal_events");
        if (!_infoMealEvents.equals(_existingMealEvents)) {
          return new RoomOpenHelper.ValidationResult(false, "meal_events(com.farmtopalm.terminal.data.db.entities.MealEventEntity).\n"
                  + " Expected:\n" + _infoMealEvents + "\n"
                  + " Found:\n" + _existingMealEvents);
        }
        final HashMap<String, TableInfo.Column> _columnsTerminalConfig = new HashMap<String, TableInfo.Column>(7);
        _columnsTerminalConfig.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTerminalConfig.put("terminalId", new TableInfo.Column("terminalId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTerminalConfig.put("schoolId", new TableInfo.Column("schoolId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTerminalConfig.put("apiBaseUrl", new TableInfo.Column("apiBaseUrl", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTerminalConfig.put("tokenEnc", new TableInfo.Column("tokenEnc", "BLOB", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTerminalConfig.put("activatedAt", new TableInfo.Column("activatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTerminalConfig.put("lastHeartbeatAt", new TableInfo.Column("lastHeartbeatAt", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTerminalConfig = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTerminalConfig = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTerminalConfig = new TableInfo("terminal_config", _columnsTerminalConfig, _foreignKeysTerminalConfig, _indicesTerminalConfig);
        final TableInfo _existingTerminalConfig = TableInfo.read(db, "terminal_config");
        if (!_infoTerminalConfig.equals(_existingTerminalConfig)) {
          return new RoomOpenHelper.ValidationResult(false, "terminal_config(com.farmtopalm.terminal.data.db.entities.TerminalConfigEntity).\n"
                  + " Expected:\n" + _infoTerminalConfig + "\n"
                  + " Found:\n" + _existingTerminalConfig);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "041e219166c0b65284bfed3c655a6b0d", "3706c49b318c5a2ea1075e7c6d307c0b");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "students","palm_templates","nfc_cards","attendance_events","meal_events","terminal_config");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `students`");
      _db.execSQL("DELETE FROM `palm_templates`");
      _db.execSQL("DELETE FROM `nfc_cards`");
      _db.execSQL("DELETE FROM `attendance_events`");
      _db.execSQL("DELETE FROM `meal_events`");
      _db.execSQL("DELETE FROM `terminal_config`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(StudentDao.class, StudentDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PalmTemplateDao.class, PalmTemplateDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(NfcCardDao.class, NfcCardDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AttendanceEventDao.class, AttendanceEventDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(MealEventDao.class, MealEventDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TerminalConfigDao.class, TerminalConfigDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public StudentDao studentDao() {
    if (_studentDao != null) {
      return _studentDao;
    } else {
      synchronized(this) {
        if(_studentDao == null) {
          _studentDao = new StudentDao_Impl(this);
        }
        return _studentDao;
      }
    }
  }

  @Override
  public PalmTemplateDao palmTemplateDao() {
    if (_palmTemplateDao != null) {
      return _palmTemplateDao;
    } else {
      synchronized(this) {
        if(_palmTemplateDao == null) {
          _palmTemplateDao = new PalmTemplateDao_Impl(this);
        }
        return _palmTemplateDao;
      }
    }
  }

  @Override
  public NfcCardDao nfcCardDao() {
    if (_nfcCardDao != null) {
      return _nfcCardDao;
    } else {
      synchronized(this) {
        if(_nfcCardDao == null) {
          _nfcCardDao = new NfcCardDao_Impl(this);
        }
        return _nfcCardDao;
      }
    }
  }

  @Override
  public AttendanceEventDao attendanceEventDao() {
    if (_attendanceEventDao != null) {
      return _attendanceEventDao;
    } else {
      synchronized(this) {
        if(_attendanceEventDao == null) {
          _attendanceEventDao = new AttendanceEventDao_Impl(this);
        }
        return _attendanceEventDao;
      }
    }
  }

  @Override
  public MealEventDao mealEventDao() {
    if (_mealEventDao != null) {
      return _mealEventDao;
    } else {
      synchronized(this) {
        if(_mealEventDao == null) {
          _mealEventDao = new MealEventDao_Impl(this);
        }
        return _mealEventDao;
      }
    }
  }

  @Override
  public TerminalConfigDao terminalConfigDao() {
    if (_terminalConfigDao != null) {
      return _terminalConfigDao;
    } else {
      synchronized(this) {
        if(_terminalConfigDao == null) {
          _terminalConfigDao = new TerminalConfigDao_Impl(this);
        }
        return _terminalConfigDao;
      }
    }
  }
}
