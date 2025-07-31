import java.util.*;

public class EmployeeSkillTracker {
    public static void main(String[] args) {
        Map<String, Set<String>> employeeSkills = new HashMap<>();
        employeeSkills.put("Shyam", new HashSet<>(Arrays.asList("Java", "SQL", "Python")));
        employeeSkills.put("Balaram",   new HashSet<>(Arrays.asList("Python", "DataStructures", "AWS")));
        employeeSkills.put("Akbar",  new HashSet<>(Arrays.asList("Java", "React", "SQL")));

        System.out.println(findEmployeesWithSkill(employeeSkills, "Java"));
        System.out.println(commonSkills(employeeSkills, "Shyam", "Balaram"));  
    }   
    static List<String> findEmployeesWithSkill(Map<String, Set<String>> map, String skill) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Set<String>> entry :map.entrySet()) {
            if (entry.getValue().contains(skill)) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    static Set<String> commonSkills(Map<String, Set<String>> map, String e1, String e2) {
        Set<String> skills1=new HashSet<>(map.get(e1));
        skills1.retainAll(map.get(e2));
        return skills1;
    }
}