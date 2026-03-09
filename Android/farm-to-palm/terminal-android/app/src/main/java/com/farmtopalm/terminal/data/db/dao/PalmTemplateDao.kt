package com.farmtopalm.terminal.data.db.dao

import androidx.room.*
import com.farmtopalm.terminal.data.db.entities.PalmTemplateEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PalmTemplateDao {
    @Query("SELECT * FROM palm_templates WHERE studentId = :studentId")
    fun getByStudent(studentId: String): Flow<List<PalmTemplateEntity>>

    @Query("SELECT * FROM palm_templates WHERE studentId = :studentId")
    suspend fun getByStudentSync(studentId: String): List<PalmTemplateEntity>

    @Query("SELECT * FROM palm_templates WHERE sdkTemplateId = :sdkTemplateId LIMIT 1")
    suspend fun getBySdkTemplateId(sdkTemplateId: String): PalmTemplateEntity?

    @Query("SELECT * FROM palm_templates")
    suspend fun getAllSync(): List<PalmTemplateEntity>

    @Query("SELECT DISTINCT studentId FROM palm_templates")
    suspend fun getEnrolledStudentIds(): List<String>

    @Query("SELECT * FROM palm_templates WHERE synced = 0")
    suspend fun getUnsynced(): List<PalmTemplateEntity>

    @Query("UPDATE palm_templates SET synced = 1 WHERE id = :id")
    suspend fun markSynced(id: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: PalmTemplateEntity)

    @Delete
    suspend fun delete(entity: PalmTemplateEntity)

    @Query("DELETE FROM palm_templates WHERE studentId = :studentId")
    suspend fun deleteByStudent(studentId: String)

    @Query("DELETE FROM palm_templates")
    suspend fun deleteAll()
}
