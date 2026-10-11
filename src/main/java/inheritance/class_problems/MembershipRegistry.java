package inheritance.class_problems;

// Static helpers that work on whole lists of memberships (P1, P2, P4, P5)
public class MembershipRegistry {

    // P1: try to build each member and count rejections - no pre-validation here
    static String enrollBatch(String[] memberIds, int borrowLimit) {
        int enrolled = 0;
        int rejected = 0;

        for (String id : memberIds) {
            try {
                new LibraryMember(id, borrowLimit);
                enrolled++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Enrolled: " + enrolled + " | Rejected: " + rejected;
    }

    // P2: instanceof checks alone, most specific type first
    // (an HonorsStudentMember is also a StudentMember and a LibraryMember)
    static String classifyGeneration(LibraryMember member) {
        if (member instanceof HonorsStudentMember) {
            return "Multilevel descendant (3 generations deep)";
        } else if (member instanceof StudentMember) {
            return "Single inheritance child (direct subclass)";
        } else if (member instanceof FacultyMember) {
            return "Hierarchical sibling (independent branch)";
        }
        return "Base class (root of the hierarchy)";
    }

    // P2: polymorphism - each object's own getBooksBorrowed() runs, no type checks
    static int getTotalBooksBorrowed(LibraryMember[] members) {
        int total = 0;
        for (LibraryMember m : members) {
            total += m.getBooksBorrowed();
        }
        return total;
    }

    // P4: one StringBuilder for the whole report; displayInfo() is called polymorphically
    static String batchPrint(LibraryMember[] members) {
        StringBuilder report = new StringBuilder();

        for (LibraryMember m : members) {
            report.append(m.displayInfo());

            // instanceof first, then the downcast - never cast and hope
            if (m instanceof StudentMember) {
                StudentMember student = (StudentMember) m;
                report.append(" [Course via downcast: ").append(student.getCourse()).append("]");
            }

            report.append(" | ");
        }

        return report.toString();
    }

    // P5: instanceof separates faculty from regular; a null entry is skipped, never thrown on
    static String processNightlyAudit(LibraryMember[] members) {
        int faculty = 0;
        int regular = 0;
        int nullSkipped = 0;

        for (LibraryMember m : members) {
            if (m == null) {
                nullSkipped++;
            } else if (m instanceof FacultyMember) {
                faculty++;
            } else {
                regular++;
            }
        }

        int processed = faculty + regular;
        return processed + " processed | " + nullSkipped + " null skipped | "
                + faculty + " faculty | " + regular + " regular";
    }
}