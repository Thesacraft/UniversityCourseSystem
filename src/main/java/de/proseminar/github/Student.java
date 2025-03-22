package de.proseminar.github;

/**
 * Represents a student with a name and a matrikelNummer.
 *
 * <p>This record is part of the example project for demonstrating GitHub Actions.</p>
 *
 * @param name           the full name of the student
 * @param matrikelNummer the unique matrikelNummer
 */
public record Student(String name, int matrikelNummer) {
}
