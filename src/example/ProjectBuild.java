package example;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import org.omg.IOP.ExceptionDetailMessage;

import java.util.*;

/*
*
* we defined graph node, adding is O(1) approach, and topological sort
* might take O(n) worst case approach
* we kept track of root nodes in case of disconnected components
* we can traverse the entire graph
*
*
* I think there is a better approach I can think of
* using double linked list and hashmap keeping count of number of out edges
*
* */

interface DependencyEvaluator {
    public void addDependency(String fromProject, String toProject);
    public String getNextProjectToBuild() throws Exception;
}

class Node{
    String val;
    List<Node> children;

    Node(String val){
        this.val = val;
        this.children = new ArrayList<>();
    }
}

public class ProjectBuild implements DependencyEvaluator {
    Map<String, Node> mapper;
    HashSet<Node> rootNodes;

    ProjectBuild(){
        this.mapper = new HashMap<>();
        this.rootNodes = new HashSet<>();
    }

    public void addDependency(String fromProject, String toProject){
        Node fromNode, toNode;
        if(this.mapper.containsKey(fromProject)){
            fromNode = mapper.get(fromProject);
        }
        else{
            fromNode = new Node(fromProject);
            mapper.put(fromProject, fromNode);
        }

        if(this.mapper.containsKey(toProject)){
            toNode = mapper.get(toProject);
        }
        else{
            toNode = new Node(toProject);
            mapper.put(toProject, toNode);
        }

        rootNodes.add(fromNode);
        // adds the dependency from fromProject to toProject
        fromNode.children.add(toNode);
        rootNodes.remove(toNode);
    }

    private void _topo(Node cur, HashSet<Node> partialVisited, HashSet<Node> totalVisit,
                       List<Node> topo_order) throws Exception {
        if(cur != null){
            partialVisited.add(cur);
            for(Node child: cur.children){
                if(!partialVisited.contains(child) && !totalVisit.contains(child)){
                    _topo(child, partialVisited, totalVisit, topo_order);
                }
                else if(partialVisited.contains(child)){
                    throw new Exception("cycle found");
                }
            }
            partialVisited.remove(cur);
            totalVisit.add(cur);
            topo_order.add(cur);
        }
    }


    @Override
    public String getNextProjectToBuild() throws Exception {
        HashSet<Node> partialVisited, totalVisit;
        List<Node> topo_order;
        for(Node cur: rootNodes){
            partialVisited = new HashSet<>();
            totalVisit = new HashSet<>();
            topo_order = new ArrayList<>();
            _topo(cur, partialVisited, totalVisit, topo_order);
            if(!topo_order.isEmpty()){
                return topo_order.get(0).val;
            }
        }
        // found nothing
        return null;
    }


    public static void main(String[] args) throws Exception {
        ProjectBuild pb = new ProjectBuild();
        pb.addDependency("a", "b");
        pb.addDependency("b", "c");
        pb.addDependency("c", "d");
        System.out.println(pb.getNextProjectToBuild());
    }

}
