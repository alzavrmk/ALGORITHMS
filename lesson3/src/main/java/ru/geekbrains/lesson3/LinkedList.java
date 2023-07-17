package ru.geekbrains.lesson3;

import java.util.Comparator;

public class LinkedList<T> {//Любой объект содержит состояние и поведение.
    // Состояние у тек класса - это указание на первый элемент связанного списка
    /**
     * Указатель на первый элемент списка
     */
    public Node head;

    /**
     * Узел
     */
    public class Node{

        /**
         * Ссылка на следующий элемент
         */
        public Node next;

        /**
         * Значение узла
         */
        public T value;

    }

    /**
     * Добавление нового элемента в начало списка
     * @param value значение
     */
    public void addFirst(T value){
        Node node = new Node();
        node.value = value;
        if (head != null){
            node.next = head;
        }
        head = node;
    }

    /**
     * Удалить первый элемент списка
     */
    public void removeFirst(){
        if (head != null){
            head = head.next;
        }
    }

    /**
     * Поиск элемента в списке по значению
     * @param value значение
     * @return узел
     */
    public Node contains(T value){
        Node node = head;
        while (node != null){
            if (node.value.equals(value))
                return node;
            node = node.next;
        }
        return null;
    }

    /**
     * Сортировка
     */
    public void sort(Comparator<T> comparator){
        Node node = head;
        while (node != null){

            Node minValueNode = node;

            Node node2 = node.next;
            while (node2 != null){
                if (comparator.compare(minValueNode.value, node2.value) > 0){
                    minValueNode = node2;
                }
                node2 = node2.next;
            }

            if (minValueNode != node){
                T buf = node.value;
                node.value = minValueNode.value;
                minValueNode.value = buf;
            }

            node = node.next;
        }
    }

    /**
     * Добавление элемента в конец списка
     * @param value значение
     */
    public void addLast(T value){
        Node node = new Node();
        node.value = value;
        if (head == null){
            head = node;
        }
        else{
            Node lastNode = head;
            while (lastNode.next != null){
                lastNode = lastNode.next;
            }
            lastNode.next = node;
        }
    }

    public void removeLast(){
        if (head == null)
            return;
        Node node = head;
        while (node.next != null){
            if (node.next.next == null){
                node.next = null;
                return;
            }
             node = node.next;
        }
        head = null;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        Node node = head;
        while (node != null){
            stringBuilder.append(node.value);
            stringBuilder.append('\n');
            node = node.next;
        }

        return stringBuilder.toString();
    }

    // Ура!! У меня получилось!!!!!!!!!!!!!!
    public void revert(){
        if (head == null)
            return;
        Node node = head;
        Node newLink = null;

        while (node.next != null){
            Node nodeNext = node.next;
            node.next = newLink;
            newLink = node;
            node = nodeNext;
        }
        head = node;
        head.next = newLink;
    }




}

