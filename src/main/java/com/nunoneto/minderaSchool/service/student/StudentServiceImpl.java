package com.nunoneto.minderaSchool.service.student;

import com.nunoneto.minderaSchool.converter.StudentConverter;
import com.nunoneto.minderaSchool.dto.student.CreateOrUpdateStudentDto;
import com.nunoneto.minderaSchool.dto.student.StudentDetailsDto;
import com.nunoneto.minderaSchool.entity.StudentEntity;
import com.nunoneto.minderaSchool.exception.ErrorMessages;
import com.nunoneto.minderaSchool.exception.exceptions.StudentNotFoundException;
import com.nunoneto.minderaSchool.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentConverter studentConverter;
    private final StudentRepository studentRepository;


    @Override
    public StudentDetailsDto createStudent(CreateOrUpdateStudentDto createOrUpdateStudentDtoDto) {
        StudentEntity studentEntity = studentConverter.convertToEntity(createOrUpdateStudentDtoDto);
        return studentConverter.convertToStudentDetailsDto(studentRepository.save(studentEntity));
    }

    @Override
    public List<StudentDetailsDto> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentConverter::convertToStudentDetailsDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDetailsDto getStudentById(Long studentId) {
        Optional<StudentEntity> studentEntityOptional = studentRepository.findById(studentId);

        return studentEntityOptional.map(studentConverter::convertToStudentDetailsDto)
                .orElseThrow( () -> new StudentNotFoundException(String.format(ErrorMessages.STUDENT_NOT_FOUND, studentId)));

    }

    @Override
    public StudentDetailsDto updateStudentById(Long studentId, CreateOrUpdateStudentDto createOrUpdateStudentDto) {

        Optional<StudentEntity> studentEntityOptional = studentRepository.findById(studentId);

        if (studentEntityOptional.isPresent()) {
            StudentEntity studentEntity = studentConverter.convertToEntity(createOrUpdateStudentDto);
            studentEntity.setStudentId(studentId);
            return studentConverter.convertToStudentDetailsDto(studentRepository.save(studentEntity));
        }
        return studentEntityOptional
                .map(studentConverter::convertToStudentDetailsDto)
                .orElseThrow(() -> new StudentNotFoundException(String.format(ErrorMessages.STUDENT_NOT_FOUND, studentId)));
    }
}