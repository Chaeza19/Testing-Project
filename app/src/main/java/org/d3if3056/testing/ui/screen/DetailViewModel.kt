package org.d3if3056.testing.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3056.testing.database.MahasiswaDao
import org.d3if3056.testing.model.Mahasiswa

class DetailViewModel(private val dao: MahasiswaDao) : ViewModel() {
    fun insert(nama: String, nim: String, kelas:String){
        val mahasiswa = Mahasiswa(
            nama = nama,
            nim = nim,
            kelas = kelas
        )
        viewModelScope.launch(Dispatchers.IO){
            dao.insert(mahasiswa)
        }
    }
    suspend fun getMahasiswa(id: Long): Mahasiswa? {
        return dao.getMahasiswaById(id)
    }
//    fun getMahasiswa(id: Long): Mahasiswa? {
//        val mahasiswas = listOf(
//            Mahasiswa(1, "Chaeza Fauzyyah Inayah", "6706223056", "D3IF-46-01"),
//            Mahasiswa(2, "Mariana", "6706223159", "D3IF-46-02"),
//            Mahasiswa(3, "Dyna Rosalina", "6706223016", "D3IF-46-02"),
//            Mahasiswa(4, "Feby Irmayana", "6706220079", "D3IF-46-02"),
//            Mahasiswa(5, "Syfanadya Wening Adi", "6706223128", "D3IF-46-03"),
//            Mahasiswa(6, "Adelia Putri", "6706223311", "D3IF-46-04"),
//            Mahasiswa(7, "Yudha Hanindyatama", "6706221234", "D3IF-46-05"),
//            Mahasiswa(8, "Desintha Hayyu Khafidah", "6706224321", "D3IF-46-05"),
//            Mahasiswa(9, "Hendro Adhy Purbowo", "6706229876", "D3IF-46-01"),
//            Mahasiswa(10, "Wiwin Erwin", "6706221357", "D3IF-46-03")
//        )
//        return mahasiswas.firstOrNull { it.id == id }
//    }

    fun update(id: Long, nama: String, nim: String, kelas: String){
        val mahasiswa = Mahasiswa(
            id = id,
            nama = nama,
            nim = nim,
            kelas = kelas
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.update(mahasiswa)
        }
    }
}