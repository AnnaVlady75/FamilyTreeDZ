package familyTree.familyTree;

import familyTree.human.Human;
import familyTree.human.comparators.HumanComparatorByBirthDate;
import familyTree.human.comparators.HumanComparatorByName;
import familyTree.human.HumanIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Iterable<Human>{
    private List<Human> humanList;
    public FamilyTree(List<Human> humanList){
        this.humanList = humanList;
    }
    public FamilyTree(){
        this(new ArrayList<>());
    }
    public boolean addHuman(Human human){
        if (human == null){
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);

            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }
    private void addToParents(Human human){
        for (Human parent:human.getParents()){
            parent.addChild(human);
        }
    }
    private void addToChildren(Human human){
        for (Human child:human.getChildren()){
            child.addParent(human);
        }
    }
    public Human getByName(String name){
        for (Human human:humanList){
            if (human.getName().equalsIgnoreCase(name)){
                return human;
            }
        }
        return null;
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("в семейном дереве: ");
        sb.append(humanList.size());
        sb.append(" членов семьи:\n");
        for (Human human:humanList){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        return getInfo();
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }
    public void sortByName(){
        humanList.sort(new HumanComparatorByName());
    }
    public void sortByBirthDate(){
        humanList.sort(new HumanComparatorByBirthDate());
    }
}
