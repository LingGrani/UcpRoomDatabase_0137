package com.example.ucp2.ui.viewmodel.dosen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2.data.entity.Dosen
import com.example.ucp2.repository.RepositoryDosen
import kotlinx.coroutines.launch

class DosenVm(private val repositoryDsn: RepositoryDosen): ViewModel(){
    var uiState by mutableStateOf(DsnUiState())

    fun updateState(dosenwEvent: DosenEvent) {
        uiState = uiState.copy(
            dosenEvent = dosenwEvent
        )
    }
    // validasi
    private fun validateFields(): Boolean {
        val event = uiState.dosenEvent
        val errorState = FormErrorState(
            nidn = if (event.nidn.isNotEmpty()) null else "NIM tidak boleh kosong",
            nama = if (event.nama.isNotEmpty()) null else "Nama tidak boleh kosong",
            jenisKelamin = if (event.jenisKelamin.isNotEmpty()) null else "Jenis Kelamin tidak boleh kosong",
        )
        uiState = uiState.copy(isEntryValid = errorState)
        return errorState.isValid()
    }
    fun saveData() {
        val currentUiState = uiState.dosenEvent
        if (validateFields()) {
            viewModelScope.launch {
                try {
                    repositoryDsn.insertDosen(currentUiState.toDosenEntity())
                    uiState = uiState.copy(
                        snackbarMessage = "Data berhasil disimpan",
                        dosenEvent = DosenEvent(),
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
data class DsnUiState(
    val dosenEvent: DosenEvent = DosenEvent(),
    val isEntryValid: FormErrorState = FormErrorState(),
    val snackbarMessage: String? = null
)

data class FormErrorState(
    val nidn: String? = null,
    val nama: String? = null,
    val jenisKelamin: String? = null,
) {
    fun isValid(): Boolean{
        return nidn == null && nama == null && jenisKelamin == null
    }
}

fun DosenEvent.toDosenEntity(): Dosen = Dosen (
    nidn = nidn,
    nama = nama,
    jenisKelamin = jenisKelamin,
)
data class DosenEvent(
    val nidn: String = "",
    val nama: String = "",
    val jenisKelamin: String = "",
)