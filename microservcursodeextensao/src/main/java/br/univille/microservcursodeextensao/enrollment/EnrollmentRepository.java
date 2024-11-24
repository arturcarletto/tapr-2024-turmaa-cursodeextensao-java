package br.univille.microservcursodeextensao.enrollment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends CrudRepository<Enrollment, String> {
}
