
package Colections;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class CarLinkedList implements CarList {

    private Node first; // Указатель на первый узел списка
    private Node last;  // Указатель на последний узел списка
    private int size = 0; // Размер списка

    @Override
    public Car get(int index) {
        // Получение значения Car по индексу
        return getNode(index).value;
    }

    @Override
    public boolean add(Car car) {
        // Добавление нового элемента в конец списка
        Node newNode = new Node(last, car, null); // Создаем новый узел
        if (last != null) {
            last.next = newNode; // Устанавливаем указатель next у предыдущего последнего узла
        } else {
            first = newNode; // Если список пустой, новый узел становится первым
        }
        last = newNode; // Обновляем указатель на последний узел
        size++; // Увеличиваем размер списка
        return true;
    }

    @Override
    public boolean add(Car car, int index) {
        // Добавление нового элемента по указанному индексу
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(); // Проверка на допустимый индекс
        }
        if (index == size) {
            add(car); // Если индекс равен размеру, добавляем в конец
            return true;
        }

        // Получаем узлы перед и после позиции вставки
        Node nodeNext = getNode(index); // Узел, следующий за вставляемым
        Node nodePrevios = nodeNext.previos; // Узел, предшествующий вставляемому
        Node newNode = new Node(nodePrevios, car, nodeNext); // Создаем новый узел

        // Устанавливаем указатели на новый узел
        if (nodePrevios != null) {
            nodePrevios.next = newNode; // Если есть предыдущий узел, устанавливаем его указатель next
        } else {
            first = newNode; // Если добавляем в начало, обновляем указатель first
        }
        nodeNext.previos = newNode; // Устанавливаем указатель previos у следующего узла

        size++; // Увеличиваем размер списка
        return true;
    }

    @Override
    public boolean remove(Car car) {
        int index = findElement(car);
        if (index != -1) {
            removeAt(index); // Удаляем узел по индексу
            return true;
        }
        return false; // Если автомобиль не найден
    }

    private int getIndex(Node node) {
        // Получение индекса узла
        int index = 0;
        Node current = first;
        while (current != null) {
            if (current == node) {
                return index; // Если узел найден, возвращаем его индекс
            }
            current = current.next; // Переход к следующему узлу
            index++;
        }
        return -1; // Если узел не найден
    }

    @Override
    public boolean removeAt(int index) {
        // Удаление элемента по индексу
        Node nodeToRemove = getNode(index); // Получаем узел для удаления
        Node nodePrevios = nodeToRemove.previos; // Узел перед удаляемым
        Node nodeNext = nodeToRemove.next; // Узел после удаляемого

        // Устанавливаем указатели для удаления узла
        if (nodePrevios != null) {
            nodePrevios.next = nodeNext; // Если есть предыдущий узел, обновляем его указатель
        } else {
            first = nodeNext; // Если удаляем первый узел, обновляем указатель first
        }

        if (nodeNext != null) {
            nodeNext.previos = nodePrevios; // Если есть следующий узел, обновляем его указатель
        } else {
            last = nodePrevios; // Если удаляем последний узел, обновляем указатель last
        }

        size--; // Уменьшаем размер списка
        return true; // Успешное удаление
    }

    @Override
    public int size() {
        // Получение текущего размера списка
        return size;
    }

    @Override
    public void clear() {
        // Очистка списка
        first = last = null; // Убираем ссылки на узлы
        size = 0; // Обнуляем размер
    }

    @Override
    public boolean contains(Car car) {
        int index = findElement(car);
        return index != -1;
    }

    @Override
    public Iterator<Car> iterator() {
        return new Iterator<Car>() {

            Node node = first; // начинаем с первой переменной

            @Override
            public boolean hasNext() { // если что то есть то true
                return node != null;
            }

            @Override
            public Car next() { // следуйщие элементы
                Car car = node.value;
                node = node.next;
                return car;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super Car> action) {
        CarList.super.forEach(action);
    }

    @Override
    public Spliterator<Car> spliterator() {
        return CarList.super.spliterator();
    }

    private int findElement(Car car) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(car)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    private Node getNode(int index) {
        // Получение узла по индексу
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(); // Проверка на допустимый индекс
        }

        Node node = first; // Начинаем с первого узла
        for (int i = 0; i < index; i++) {
            node = node.next; // Переход к следующему узлу
        }
        return node; // Возвращаем узел по индексу
    }

    private static class Node {
        private Node previos; // Указатель на предыдущий узел
        private Car value; // Значение узла
        private Node next; // Указатель на следующий узел

        public Node(Node previos, Car value, Node next) {
            this.previos = previos; // Инициализация указателя на предыдущий узел
            this.value = value; // Инициализация значения узла
            this.next = next; // Инициализация указателя на следующий узел
        }
    }

}
