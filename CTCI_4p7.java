import java.util.ArrayList;

/**
 *  Trees and Graphs
 *
 *  Problem 4.7
 *
 *  You are given a list of projects and a list of dependencies (which is a list of pairs of
 *  projects, where the first project is dependent on ths second project).  All of a project's
 *  dependencies must be built before the project is.  Find a build order that will allow the projects
 *  to be built.  If there is no valid build order, return an error.
 *
 */
public class CTCI_4p7 {

    public static void main(String... args) {
        ArrayList<Projects> projects = new ArrayList<>();

        // create projects
        Projects a = new Projects('a');
        Projects b = new Projects('b');
        Projects c = new Projects('c');
        Projects d = new Projects('d');
        Projects e = new Projects('e');
        Projects f = new Projects('f');

        // add to projects list
        projects.add(a);
        projects.add(b);
        projects.add(c);
        projects.add(d);
        projects.add(e);
        projects.add(f);

        // add dependencies
        a.addDependency(f);
        b.addDependency(f);
        c.addDependency(d);
        d.addDependency(a);
        d.addDependency(b);

        System.out.println(isBuildOrder(projects));
    }

    private static class Projects {
        char name;
        boolean inValidate = false;
        ArrayList<Projects> dependencies = new ArrayList<>();

        protected Projects(char name) {
            this.name = name;
        }

        protected void addDependency(Projects p) {
            this.dependencies.add(p);
        }
    }

    /**
     *  Algorithm Design
     *
     *  @param projects - the array of projects
     *  @return - there is a valid build order
     *
     *  Example:
     *
     *  Input:
     *      projects: a, b, c, d, e, f
     *      dependencies: (d, a), (b, f), (d, b), (a, f), (c, d)
     *
     *  Output:
     *      f, e, a, b, d, c
     *
     */
    static String isBuildOrder(ArrayList<Projects> projects) {
        if(projects == null || projects.size() == 0) throw new IllegalArgumentException();

        ArrayList<Character> output = new ArrayList<>();

        int invalidCount = 0;

        // add the project names without dependencies to the output
        for(int i = 0; i < projects.size(); ++i) {
            if(projects.get(i).dependencies.size() == 0 && projects.get(i).inValidate == false) {
                output.add(projects.get(i).name);
                projects.get(i).inValidate = true;
                invalidCount++;
            }
        }

        // keep track of the project dependencies
        boolean flag = false;

        // sort out the dependencies
        while(true) {
            for(Projects p : projects) {
                if(p.inValidate == false && p.dependencies.size() != 0) {
                    flag = false;
                    for (int i = 0; i < p.dependencies.size(); ++i) {
                        if (output.contains(p.dependencies.get(i).name)) flag = true;
                    }
                    if(flag) {
                        output.add(p.name);
                        p.inValidate = true;
                        invalidCount++;
                    }
                }
            }
            if(invalidCount == projects.size()) break;
        }

        return output.toString();
    }

}
