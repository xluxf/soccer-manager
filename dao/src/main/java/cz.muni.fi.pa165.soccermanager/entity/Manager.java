package cz.muni.fi.pa165.soccermanager.entity;

import javax.persistence.*;

/**
 * Class representing club manager entity.
 * Mandatory attributes are name, email and nationality.
 * Instances should be created by using ManagerBuilder.
 * @author Martin Hamerník 445720
 * @version 10/29/2017
 */
@Entity
public class Manager {

    public static class ManagerBuilder {
        private String name;
        private String nationality;
        private Team team;
        private String email;

        public ManagerBuilder() {}

        public ManagerBuilder(String name, String nationality, String email) {
            this.name = name;
            this.nationality = nationality;
            this.email = email;
        }

        public ManagerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ManagerBuilder nationality(String nationality) {
            this.nationality = nationality;
            return this;
        }

        public ManagerBuilder email(String email) {
            this.email = email;
            return this;
        }

        public ManagerBuilder team(Team team) {
            this.team = team;
            return this;
        }

        public Manager build() {
            return new Manager(this);
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nationality;

    @OneToOne
    private Team team;

    @Column(nullable = false)
    private String email;

    public Manager() {

    }

    private Manager(ManagerBuilder builder) {
            this.name = builder.name;
            this.nationality = builder.nationality;
            this.email = builder.email;
            this.team = builder.team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager)) return false;

        Manager manager = (Manager) o;

        if (!name.equals(manager.name)) return false;
        if (!nationality.equals(manager.nationality)) return false;
        return email.equals(manager.email);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + nationality.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
