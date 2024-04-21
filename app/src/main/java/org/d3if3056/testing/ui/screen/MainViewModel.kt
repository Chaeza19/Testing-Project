package org.d3if3056.testing.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.d3if3056.testing.database.MahasiswaDao
import org.d3if3056.testing.model.Mahasiswa

class MainViewModel(dao: MahasiswaDao) : ViewModel() {
//    val data = getDataDummy()
    val data: StateFlow<List<Mahasiswa>> = dao.getMahasiswa().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )

    private fun getDataDummy():List<Mahasiswa>{
        val data = mutableListOf<Mahasiswa>()

        val nama = listOf(
            "Chaeza Fauzyyah Inayah",
            "Mariana",
            "Dyna Rosalina",
            "Feby Irmayana",
            "Syfanadya Wening Adi",
            "Adelia Putri",
            "Yudha Hanindyatama",
            "Desintha Hayyu Khafidah",
            "Hendro Adhy Purbowo",
            "Wiwin Erwin"
        )

        val nim = listOf(
            "6706223056",
            "6706223159",
            "6706223016",
            "6706220079",
            "6706223128",
            "6706223311",
            "6706221234",
            "6706224321",
            "6706229876",
            "6706221357"
        )

        val kelas = listOf(
            "D3IF-46-01",
            "D3IF-46-02",
            "D3IF-46-02",
            "D3IF-46-02",
            "D3IF-46-03",
            "D3IF-46-04",
            "D3IF-46-05",
            "D3IF-46-05",
            "D3IF-46-01",
            "D3IF-46-03",
        )

        for (kelasIndex in 1 .. 5){
            for (i in nama.indices){
                val kelasIndexFormatted = "%02d".format(kelasIndex)
                val kelasFilter = "D3IF-46-$kelasIndexFormatted"
                if (kelas[i] == kelasFilter){
                    data.add(
                        Mahasiswa(
                            (i + 1).toLong(),
                            nama[i],
                            nim[i],
                            kelas[i % kelas.size]
                        )
                    )
                }
            }
        }
        return data
    }
}