package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
