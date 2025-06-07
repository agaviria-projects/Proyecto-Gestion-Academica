package gestor.gestor_academico.service;

import gestor.gestor_academico.model.Nota;
import gestor.gestor_academico.repository.NotaRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    public byte[] exportarNotasSegunRol(String rol, String correo) {
        List<Nota> notasFiltradas;

        if ("ESTUDIANTE".equalsIgnoreCase(rol)) {
            notasFiltradas = notaRepository.findByEstudianteEmail(correo);
        } else if ("PROFESOR".equalsIgnoreCase(rol)) {
            notasFiltradas = notaRepository.findByProfesorEmail(correo);
        } else {
            notasFiltradas = notaRepository.findAll();
        }

        return generarExcelDesdeNotas(notasFiltradas);
    }

    public byte[] generarExcelDesdeNotas(List<Nota> notas) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Notas");

            // Encabezados
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Estudiante");
            header.createCell(1).setCellValue("Curso");
            header.createCell(2).setCellValue("Nota");
            header.createCell(3).setCellValue("Fecha");

            // Filas de datos
            int rowIdx = 1;
            for (Nota nota : notas) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(
                        nota.getEstudiante().getNombre() + " " + nota.getEstudiante().getApellido()
                );
                row.createCell(1).setCellValue(nota.getCurso().getNombre());
                row.createCell(2).setCellValue(nota.getNota());
                row.createCell(3).setCellValue(nota.getFechaNota().toString());
            }

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            return out.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public List<Nota> obtenerTodasLasNotas(){
        return notaRepository.findAll();
    }

    public Optional<Nota> obtenerNotaPorId(Long id){
        return notaRepository.findById(id);
    }

    public Nota guardarNota(Nota nota){
        return notaRepository.save(nota);
    }

    public Long contarNotas(){
        return notaRepository.count();
    }

    public boolean existePorId(Long id) {
        return notaRepository.existsById(id);
    }

    public void eliminarNota(Long id){
        notaRepository.deleteById(id);
    }
}

