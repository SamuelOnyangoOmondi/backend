package com.farmtopalm.terminal.data.db.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.farmtopalm.terminal.data.db.entities.TerminalConfigEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class TerminalConfigDao_Impl implements TerminalConfigDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TerminalConfigEntity> __insertionAdapterOfTerminalConfigEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateHeartbeat;

  public TerminalConfigDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTerminalConfigEntity = new EntityInsertionAdapter<TerminalConfigEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `terminal_config` (`id`,`terminalId`,`schoolId`,`apiBaseUrl`,`tokenEnc`,`activatedAt`,`lastHeartbeatAt`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final TerminalConfigEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTerminalId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTerminalId());
        }
        if (entity.getSchoolId() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getSchoolId());
        }
        if (entity.getApiBaseUrl() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getApiBaseUrl());
        }
        if (entity.getTokenEnc() == null) {
          statement.bindNull(5);
        } else {
          statement.bindBlob(5, entity.getTokenEnc());
        }
        statement.bindLong(6, entity.getActivatedAt());
        if (entity.getLastHeartbeatAt() == null) {
          statement.bindNull(7);
        } else {
          statement.bindLong(7, entity.getLastHeartbeatAt());
        }
      }
    };
    this.__preparedStmtOfUpdateHeartbeat = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE terminal_config SET lastHeartbeatAt = ? WHERE id = 1";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final TerminalConfigEntity entity, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTerminalConfigEntity.insert(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object updateHeartbeat(final long at, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateHeartbeat.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, at);
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
          __preparedStmtOfUpdateHeartbeat.release(_stmt);
        }
      }
    }, arg1);
  }

  @Override
  public Object get(final Continuation<? super TerminalConfigEntity> arg0) {
    final String _sql = "SELECT * FROM terminal_config WHERE id = 1 LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<TerminalConfigEntity>() {
      @Override
      @Nullable
      public TerminalConfigEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTerminalId = CursorUtil.getColumnIndexOrThrow(_cursor, "terminalId");
          final int _cursorIndexOfSchoolId = CursorUtil.getColumnIndexOrThrow(_cursor, "schoolId");
          final int _cursorIndexOfApiBaseUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "apiBaseUrl");
          final int _cursorIndexOfTokenEnc = CursorUtil.getColumnIndexOrThrow(_cursor, "tokenEnc");
          final int _cursorIndexOfActivatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "activatedAt");
          final int _cursorIndexOfLastHeartbeatAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastHeartbeatAt");
          final TerminalConfigEntity _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTerminalId;
            if (_cursor.isNull(_cursorIndexOfTerminalId)) {
              _tmpTerminalId = null;
            } else {
              _tmpTerminalId = _cursor.getString(_cursorIndexOfTerminalId);
            }
            final String _tmpSchoolId;
            if (_cursor.isNull(_cursorIndexOfSchoolId)) {
              _tmpSchoolId = null;
            } else {
              _tmpSchoolId = _cursor.getString(_cursorIndexOfSchoolId);
            }
            final String _tmpApiBaseUrl;
            if (_cursor.isNull(_cursorIndexOfApiBaseUrl)) {
              _tmpApiBaseUrl = null;
            } else {
              _tmpApiBaseUrl = _cursor.getString(_cursorIndexOfApiBaseUrl);
            }
            final byte[] _tmpTokenEnc;
            if (_cursor.isNull(_cursorIndexOfTokenEnc)) {
              _tmpTokenEnc = null;
            } else {
              _tmpTokenEnc = _cursor.getBlob(_cursorIndexOfTokenEnc);
            }
            final long _tmpActivatedAt;
            _tmpActivatedAt = _cursor.getLong(_cursorIndexOfActivatedAt);
            final Long _tmpLastHeartbeatAt;
            if (_cursor.isNull(_cursorIndexOfLastHeartbeatAt)) {
              _tmpLastHeartbeatAt = null;
            } else {
              _tmpLastHeartbeatAt = _cursor.getLong(_cursorIndexOfLastHeartbeatAt);
            }
            _result = new TerminalConfigEntity(_tmpId,_tmpTerminalId,_tmpSchoolId,_tmpApiBaseUrl,_tmpTokenEnc,_tmpActivatedAt,_tmpLastHeartbeatAt);
          } else {
            _result = null;
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
