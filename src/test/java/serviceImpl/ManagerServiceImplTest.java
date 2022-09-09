package serviceImpl;

import enums.Roles;
import model.Applicant;
import model.Cashier;
import model.Manager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerServiceImplTest {
    Manager manager = Manager.getInstance();
    Applicant applicant = new Applicant("tola",80,4);
    ManagerServiceImpl manager1 = new ManagerServiceImpl();
    Cashier cashier = new Cashier();
    @BeforeEach
    void setUp() {



        }
    @Test
    void shouldHireIfApplicantIsGreaterThan25() {
        Assertions.assertTrue(this.manager1.canHire(applicant));
}}