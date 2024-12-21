package com.example.ucp2.ui.viewmodel.matakuliah

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2.data.entity.Dosen
import com.example.ucp2.data.entity.Matakuliah
import com.example.ucp2.repository.RepositoryMatakuliah
import kotlinx.coroutines.launch

class MatakuliahVm(private val repositoryMk: RepositoryMatakuliah): ViewModel(){
    var uiState by mutableStateOf(MkUiState())

    fun updateState(mkEvent: MkEvent) {
        uiState = uiState.copy(
            mkEvent = mkEvent
        )
    }
    // validasi
    private fun validateFields(): Boolean {
        val event = uiState.mkEvent
        val errorState = FormErrorState(
            kode = if (event.kode.isNotEmpty()) null else "NIM tidak boleh kosong",
            nama = if (event.nama.isNotEmpty()) null else "Nama tidak boleh kosong",
            sks = if (event.sks.isNotEmpty()) null else "SKS tidak boleh kosong",
            semester = if (event.semester.isNotEmpty()) null else "Semester tidak boleh kosong",
            jenis = if (event.jenis.isNotEmpty()) null else "Jenis Matakuliah tidak boleh kosong",
            dosenPengampu = if (event.dosenPengampu.isNotEmpty()) null else "Dosen Pengampu tidak boleh kosong",
        )
        uiState = uiState.copy(isEntryValid = errorState)
        return errorState.isValid()
    }
    fun saveData() {
        val currentUiState = uiState.mkEvent
        if (validateFields()) {
            viewModelScope.launch {
                try {
                    repositoryMk.insertMatakuliah(currentUiState.toMkEntity())
                    uiState = uiState.copy(
                        snackbarMessage = "Data berhasil disimpan",
                        mkEvent = MkEvent(),
                        isEntryValid = FormErrorState()
                    )
                } catch (e: Exception) {
                    uiState = uiState.copy(
                        snackbarMessage = "Data gagal disimpan"
                    )
                }
            }
        }
    }
    fun resetSnackBarMessage() {
        uiState = uiState.copy(snackbarMessage = null)
    }

}
data class MkUiState(
    val mkEvent: MkEvent = MkEvent(),
    val isEntryValid: FormErrorState = FormErrorState(),
    val snackbarMessage: String? = null
)

data class FormErrorState(
    val kode: String? = null,
    val nama: String? = null,
    val sks: String? = null,
    val semester: String? = null,
    val jenis: String? = null,
    val dosenPengampu: String? = null,
) {
    fun isValid(): Boolean{
        return kode == null && nama == null && sks == null && semester == null && jenis == null && dosenPengampu == null
    }
}

fun MkEvent.toMkEntity(): Matakuliah = Matakuliah (
    kode = kode,
    nama = nama,
    sks = sks,
    semester = semester,
    jenis = jenis,
    dosenPengampu = dosenPengampu,
)
data class MkEvent(
    val kode: String = "",
    val nama: String = "",
    val sks: String = "",
    val semester: String = "",
    val jenis: String = "",
    val dosenPengampu: String = "",
)