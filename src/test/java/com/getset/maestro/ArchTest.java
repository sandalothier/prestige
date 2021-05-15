package com.getset.maestro;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.getset.maestro");

        noClasses()
            .that()
            .resideInAnyPackage("com.getset.maestro.service..")
            .or()
            .resideInAnyPackage("com.getset.maestro.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.getset.maestro.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
