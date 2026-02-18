package com.farmtopalm.terminal.data.db.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.farmtopalm.terminal.data.db.entities.PalmTemplateEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class PalmTemplateDao_Impl implements PalmTemplateDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PalmTemplateEntity> __insertionAdapterOfPalmTemplateEntity;

  private final EntityDeletionOrUpdateAdapter<PalmTemplateEntity> __deletionAdapterOfPalmTemplateEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByStudent;

  public PalmTemplateDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPalmTemplateEntity = new EntityInsertionAdapter<PalmTemplateEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `palm_templates` (`id`,`studentId`,`hand`,`rgbFeatureEnc`,`irFeatureEnc`,`quality`,`createdAt`,`streamType`,`rgbModelHash`,`irModelHash`,`sdkTemplateId`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PalmTemplateEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getStudentId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getStudentId());
        }
        if (entity.getHand() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getHand());
        }
        if (entity.getRgbFeatureEnc() == null) {
          statement.bindNull(4);
        } else {
          statement.bindBlob(4, entity.getRgbFeatureEnc());
        }
        if (entity.getIrFeatureEnc() == null) {
          statement.bindNull(5);
        } else {
          statement.bindBlob(5, entity.getIrFeatureEnc());
        }
        statement.bindLong(6, entity.getQuality());
        statement.bindLong(7, entity.getCreatedAt());
        if (entity.getStreamType() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getStreamType());
        }
        if (entity.getRgbModelHash() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getRgbModelHash());
        }
        if (entity.getIrModelHash() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getIrModelHash());
        }
        if (entity.getSdkTemplateId() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getSdkTemplateId());
        }
      }
    };
    this.__deletionAdapterOfPalmTemplateEntity = new EntityDeletionOrUpdateAdapter<PalmTemplateEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `palm_templates` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PalmTemplateEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteByStudent = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM palm_templates WHERE studentId = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final PalmTemplateEntity entity, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPalmTemplateEntity.insert(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object delete(final PalmTemplateEntity entity, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfPalmTemplateEntity.handle(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object deleteByStudent(final String studentId, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteByStudent.acquire();
        int _argIndex = 1;
        if (studentId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, studentId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteByStudent.release(_stmt);
        }
      }
    }, arg1);
  }

  @Override
  public Flow<List<PalmTemplateEntity>> getByStudent(final String studentId) {
    final String _sql = "SELECT * FROM palm_templates WHERE studentId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (studentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, studentId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"palm_templates"}, new Callable<List<PalmTemplateEntity>>() {
      @Override
      @NonNull
      public List<PalmTemplateEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfStudentId = CursorUtil.getColumnIndexOrThrow(_cursor, "studentId");
          final int _cursorIndexOfHand = CursorUtil.getColumnIndexOrThrow(_cursor, "hand");
          final int _cursorIndexOfRgbFeatureEnc = CursorUtil.getColumnIndexOrThrow(_cursor, "rgbFeatureEnc");
          final int _cursorIndexOfIrFeatureEnc = CursorUtil.getColumnIndexOrThrow(_cursor, "irFeatureEnc");
          final int _cursorIndexOfQuality = CursorUtil.getColumnIndexOrThrow(_cursor, "quality");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfStreamType = CursorUtil.getColumnIndexOrThrow(_cursor, "streamType");
          final int _cursorIndexOfRgbModelHash = CursorUtil.getColumnIndexOrThrow(_cursor, "rgbModelHash");
          final int _cursorIndexOfIrModelHash = CursorUtil.getColumnIndexOrThrow(_cursor, "irModelHash");
          final int _cursorIndexOfSdkTemplateId = CursorUtil.getColumnIndexOrThrow(_cursor, "sdkTemplateId");
          final List<PalmTemplateEntity> _result = new ArrayList<PalmTemplateEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PalmTemplateEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpStudentId;
            if (_cursor.isNull(_cursorIndexOfStudentId)) {
              _tmpStudentId = null;
            } else {
              _tmpStudentId = _cursor.getString(_cursorIndexOfStudentId);
            }
            final String _tmpHand;
            if (_cursor.isNull(_cursorIndexOfHand)) {
              _tmpHand = null;
            } else {
              _tmpHand = _cursor.getString(_cursorIndexOfHand);
            }
            final byte[] _tmpRgbFeatureEnc;
            if (_cursor.isNull(_cursorIndexOfRgbFeatureEnc)) {
              _tmpRgbFeatureEnc = null;
            } else {
              _tmpRgbFeatureEnc = _cursor.getBlob(_cursorIndexOfRgbFeatureEnc);
            }
            final byte[] _tmpIrFeatureEnc;
            if (_cursor.isNull(_cursorIndexOfIrFeatureEnc)) {
              _tmpIrFeatureEnc = null;
            } else {
              _tmpIrFeatureEnc = _cursor.getBlob(_cursorIndexOfIrFeatureEnc);
            }
            final int _tmpQuality;
            _tmpQuality = _cursor.getInt(_cursorIndexOfQuality);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final String _tmpStreamType;
            if (_cursor.isNull(_cursorIndexOfStreamType)) {
              _tmpStreamType = null;
            } else {
              _tmpStreamType = _cursor.getString(_cursorIndexOfStreamType);
            }
            final String _tmpRgbModelHash;
            if (_cursor.isNull(_cursorIndexOfRgbModelHash)) {
              _tmpRgbModelHash = null;
            } else {
              _tmpRgbModelHash = _cursor.getString(_cursorIndexOfRgbModelHash);
            }
            final String _tmpIrModelHash;
            if (_cursor.isNull(_cursorIndexOfIrModelHash)) {
              _tmpIrModelHash = null;
            } else {
              _tmpIrModelHash = _cursor.getString(_cursorIndexOfIrModelHash);
            }
            final String _tmpSdkTemplateId;
            if (_cursor.isNull(_cursorIndexOfSdkTemplateId)) {
              _tmpSdkTemplateId = null;
            } else {
              _tmpSdkTemplateId = _cursor.getString(_cursorIndexOfSdkTemplateId);
            }
            _item = new PalmTemplateEntity(_tmpId,_tmpStudentId,_tmpHand,_tmpRgbFeatureEnc,_tmpIrFeatureEnc,_tmpQuality,_tmpCreatedAt,_tmpStreamType,_tmpRgbModelHash,_tmpIrModelHash,_tmpSdkTemplateId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getByStudentSync(final String studentId,
      final Continuation<? super List<PalmTemplateEntity>> arg1) {
    final String _sql = "SELECT * FROM palm_templates WHERE studentId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (studentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, studentId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<PalmTemplateEntity>>() {
      @Override
      @NonNull
      public List<PalmTemplateEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfStudentId = CursorUtil.getColumnIndexOrThrow(_cursor, "studentId");
          final int _cursorIndexOfHand = CursorUtil.getColumnIndexOrThrow(_cursor, "hand");
          final int _cursorIndexOfRgbFeatureEnc = CursorUtil.getColumnIndexOrThrow(_cursor, "rgbFeatureEnc");
          final int _cursorIndexOfIrFeatureEnc = CursorUtil.getColumnIndexOrThrow(_cursor, "irFeatureEnc");
          final int _cursorIndexOfQuality = CursorUtil.getColumnIndexOrThrow(_cursor, "quality");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfStreamType = CursorUtil.getColumnIndexOrThrow(_cursor, "streamType");
          final int _cursorIndexOfRgbModelHash = CursorUtil.getColumnIndexOrThrow(_cursor, "rgbModelHash");
          final int _cursorIndexOfIrModelHash = CursorUtil.getColumnIndexOrThrow(_cursor, "irModelHash");
          final int _cursorIndexOfSdkTemplateId = CursorUtil.getColumnIndexOrThrow(_cursor, "sdkTemplateId");
          final List<PalmTemplateEntity> _result = new ArrayList<PalmTemplateEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PalmTemplateEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpStudentId;
            if (_cursor.isNull(_cursorIndexOfStudentId)) {
              _tmpStudentId = null;
            } else {
              _tmpStudentId = _cursor.getString(_cursorIndexOfStudentId);
            }
            final String _tmpHand;
            if (_cursor.isNull(_cursorIndexOfHand)) {
              _tmpHand = null;
            } else {
              _tmpHand = _cursor.getString(_cursorIndexOfHand);
            }
            final byte[] _tmpRgbFeatureEnc;
            if (_cursor.isNull(_cursorIndexOfRgbFeatureEnc)) {
              _tmpRgbFeatureEnc = null;
            } else {
              _tmpRgbFeatureEnc = _cursor.getBlob(_cursorIndexOfRgbFeatureEnc);
            }
            final byte[] _tmpIrFeatureEnc;
            if (_cursor.isNull(_cursorIndexOfIrFeatureEnc)) {
              _tmpIrFeatureEnc = null;
            } else {
              _tmpIrFeatureEnc = _cursor.getBlob(_cursorIndexOfIrFeatureEnc);
            }
            final int _tmpQuality;
            _tmpQuality = _cursor.getInt(_cursorIndexOfQuality);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final String _tmpStreamType;
            if (_cursor.isNull(_cursorIndexOfStreamType)) {
              _tmpStreamType = null;
            } else {
              _tmpStreamType = _cursor.getString(_cursorIndexOfStreamType);
            }
            final String _tmpRgbModelHash;
            if (_cursor.isNull(_cursorIndexOfRgbModelHash)) {
              _tmpRgbModelHash = null;
            } else {
              _tmpRgbModelHash = _cursor.getString(_cursorIndexOfRgbModelHash);
            }
            final String _tmpIrModelHash;
            if (_cursor.isNull(_cursorIndexOfIrModelHash)) {
              _tmpIrModelHash = null;
            } else {
              _tmpIrModelHash = _cursor.getString(_cursorIndexOfIrModelHash);
            }
            final String _tmpSdkTemplateId;
            if (_cursor.isNull(_cursorIndexOfSdkTemplateId)) {
              _tmpSdkTemplateId = null;
            } else {
              _tmpSdkTemplateId = _cursor.getString(_cursorIndexOfSdkTemplateId);
            }
            _item = new PalmTemplateEntity(_tmpId,_tmpStudentId,_tmpHand,_tmpRgbFeatureEnc,_tmpIrFeatureEnc,_tmpQuality,_tmpCreatedAt,_tmpStreamType,_tmpRgbModelHash,_tmpIrModelHash,_tmpSdkTemplateId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, arg1);
  }

  @Override
  public Object getBySdkTemplateId(final String sdkTemplateId,
      final Continuation<? super PalmTemplateEntity> arg1) {
    final String _sql = "SELECT * FROM palm_templates WHERE sdkTemplateId = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (sdkTemplateId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sdkTemplateId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<PalmTemplateEntity>() {
      @Override
      @Nullable
      public PalmTemplateEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfStudentId = CursorUtil.getColumnIndexOrThrow(_cursor, "studentId");
          final int _cursorIndexOfHand = CursorUtil.getColumnIndexOrThrow(_cursor, "hand");
          final int _cursorIndexOfRgbFeatureEnc = CursorUtil.getColumnIndexOrThrow(_cursor, "rgbFeatureEnc");
          final int _cursorIndexOfIrFeatureEnc = CursorUtil.getColumnIndexOrThrow(_cursor, "irFeatureEnc");
          final int _cursorIndexOfQuality = CursorUtil.getColumnIndexOrThrow(_cursor, "quality");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfStreamType = CursorUtil.getColumnIndexOrThrow(_cursor, "streamType");
          final int _cursorIndexOfRgbModelHash = CursorUtil.getColumnIndexOrThrow(_cursor, "rgbModelHash");
          final int _cursorIndexOfIrModelHash = CursorUtil.getColumnIndexOrThrow(_cursor, "irModelHash");
          final int _cursorIndexOfSdkTemplateId = CursorUtil.getColumnIndexOrThrow(_cursor, "sdkTemplateId");
          final PalmTemplateEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpStudentId;
            if (_cursor.isNull(_cursorIndexOfStudentId)) {
              _tmpStudentId = null;
            } else {
              _tmpStudentId = _cursor.getString(_cursorIndexOfStudentId);
            }
            final String _tmpHand;
            if (_cursor.isNull(_cursorIndexOfHand)) {
              _tmpHand = null;
            } else {
              _tmpHand = _cursor.getString(_cursorIndexOfHand);
            }
            final byte[] _tmpRgbFeatureEnc;
            if (_cursor.isNull(_cursorIndexOfRgbFeatureEnc)) {
              _tmpRgbFeatureEnc = null;
            } else {
              _tmpRgbFeatureEnc = _cursor.getBlob(_cursorIndexOfRgbFeatureEnc);
            }
            final byte[] _tmpIrFeatureEnc;
            if (_cursor.isNull(_cursorIndexOfIrFeatureEnc)) {
              _tmpIrFeatureEnc = null;
            } else {
              _tmpIrFeatureEnc = _cursor.getBlob(_cursorIndexOfIrFeatureEnc);
            }
            final int _tmpQuality;
            _tmpQuality = _cursor.getInt(_cursorIndexOfQuality);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final String _tmpStreamType;
            if (_cursor.isNull(_cursorIndexOfStreamType)) {
              _tmpStreamType = null;
            } else {
              _tmpStreamType = _cursor.getString(_cursorIndexOfStreamType);
            }
            final String _tmpRgbModelHash;
            if (_cursor.isNull(_cursorIndexOfRgbModelHash)) {
              _tmpRgbModelHash = null;
            } else {
              _tmpRgbModelHash = _cursor.getString(_cursorIndexOfRgbModelHash);
            }
            final String _tmpIrModelHash;
            if (_cursor.isNull(_cursorIndexOfIrModelHash)) {
              _tmpIrModelHash = null;
            } else {
              _tmpIrModelHash = _cursor.getString(_cursorIndexOfIrModelHash);
            }
            final String _tmpSdkTemplateId;
            if (_cursor.isNull(_cursorIndexOfSdkTemplateId)) {
              _tmpSdkTemplateId = null;
            } else {
              _tmpSdkTemplateId = _cursor.getString(_cursorIndexOfSdkTemplateId);
            }
            _result = new PalmTemplateEntity(_tmpId,_tmpStudentId,_tmpHand,_tmpRgbFeatureEnc,_tmpIrFeatureEnc,_tmpQuality,_tmpCreatedAt,_tmpStreamType,_tmpRgbModelHash,_tmpIrModelHash,_tmpSdkTemplateId);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, arg1);
  }

  @Override
  public Object getAllSync(final Continuation<? super List<PalmTemplateEntity>> arg0) {
    final String _sql = "SELECT * FROM palm_templates";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<PalmTemplateEntity>>() {
      @Override
      @NonNull
      public List<PalmTemplateEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfStudentId = CursorUtil.getColumnIndexOrThrow(_cursor, "studentId");
          final int _cursorIndexOfHand = CursorUtil.getColumnIndexOrThrow(_cursor, "hand");
          final int _cursorIndexOfRgbFeatureEnc = CursorUtil.getColumnIndexOrThrow(_cursor, "rgbFeatureEnc");
          final int _cursorIndexOfIrFeatureEnc = CursorUtil.getColumnIndexOrThrow(_cursor, "irFeatureEnc");
          final int _cursorIndexOfQuality = CursorUtil.getColumnIndexOrThrow(_cursor, "quality");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfStreamType = CursorUtil.getColumnIndexOrThrow(_cursor, "streamType");
          final int _cursorIndexOfRgbModelHash = CursorUtil.getColumnIndexOrThrow(_cursor, "rgbModelHash");
          final int _cursorIndexOfIrModelHash = CursorUtil.getColumnIndexOrThrow(_cursor, "irModelHash");
          final int _cursorIndexOfSdkTemplateId = CursorUtil.getColumnIndexOrThrow(_cursor, "sdkTemplateId");
          final List<PalmTemplateEntity> _result = new ArrayList<PalmTemplateEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PalmTemplateEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpStudentId;
            if (_cursor.isNull(_cursorIndexOfStudentId)) {
              _tmpStudentId = null;
            } else {
              _tmpStudentId = _cursor.getString(_cursorIndexOfStudentId);
            }
            final String _tmpHand;
            if (_cursor.isNull(_cursorIndexOfHand)) {
              _tmpHand = null;
            } else {
              _tmpHand = _cursor.getString(_cursorIndexOfHand);
            }
            final byte[] _tmpRgbFeatureEnc;
            if (_cursor.isNull(_cursorIndexOfRgbFeatureEnc)) {
              _tmpRgbFeatureEnc = null;
            } else {
              _tmpRgbFeatureEnc = _cursor.getBlob(_cursorIndexOfRgbFeatureEnc);
            }
            final byte[] _tmpIrFeatureEnc;
            if (_cursor.isNull(_cursorIndexOfIrFeatureEnc)) {
              _tmpIrFeatureEnc = null;
            } else {
              _tmpIrFeatureEnc = _cursor.getBlob(_cursorIndexOfIrFeatureEnc);
            }
            final int _tmpQuality;
            _tmpQuality = _cursor.getInt(_cursorIndexOfQuality);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final String _tmpStreamType;
            if (_cursor.isNull(_cursorIndexOfStreamType)) {
              _tmpStreamType = null;
            } else {
              _tmpStreamType = _cursor.getString(_cursorIndexOfStreamType);
            }
            final String _tmpRgbModelHash;
            if (_cursor.isNull(_cursorIndexOfRgbModelHash)) {
              _tmpRgbModelHash = null;
            } else {
              _tmpRgbModelHash = _cursor.getString(_cursorIndexOfRgbModelHash);
            }
            final String _tmpIrModelHash;
            if (_cursor.isNull(_cursorIndexOfIrModelHash)) {
              _tmpIrModelHash = null;
            } else {
              _tmpIrModelHash = _cursor.getString(_cursorIndexOfIrModelHash);
            }
            final String _tmpSdkTemplateId;
            if (_cursor.isNull(_cursorIndexOfSdkTemplateId)) {
              _tmpSdkTemplateId = null;
            } else {
              _tmpSdkTemplateId = _cursor.getString(_cursorIndexOfSdkTemplateId);
            }
            _item = new PalmTemplateEntity(_tmpId,_tmpStudentId,_tmpHand,_tmpRgbFeatureEnc,_tmpIrFeatureEnc,_tmpQuality,_tmpCreatedAt,_tmpStreamType,_tmpRgbModelHash,_tmpIrModelHash,_tmpSdkTemplateId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, arg0);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
