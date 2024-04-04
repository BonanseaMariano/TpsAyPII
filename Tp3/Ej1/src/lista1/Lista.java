package lista1;

public class Lista<E> {

    private E[] array;
    private int size;

    public int getSize() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public Lista(int capacity) {
        array = (E[]) new Object[capacity];
        size = 0;
    }

    public void add(E e) throws IndexOutOfBoundsException {
        if (size < array.length) {
            array[size++] = e;
        } else {
            throw new IndexOutOfBoundsException("La lista esta llena.");
        }
    }

    public void add(int p, E e) throws IndexOutOfBoundsException {
        if (p >= 0 && p <= size) {
            if (size < array.length) {
                //Desplaza todo lo que se encuentra desde la posicion a la derecha una posicion a la derecha para insertar el nuevo elemento
                System.arraycopy(array, p, array, p + 1, size - p);
                array[p] = e;
                size++;
            } else {
                throw new IndexOutOfBoundsException("La lista esta llena.");
            }
        } else {
            throw new IndexOutOfBoundsException("Indice fuera de rango.");
        }
    }

    public E get(int p) throws IndexOutOfBoundsException {
        if (p >= 0 && p < size) {
            return array[p];
        } else {
            throw new IndexOutOfBoundsException("Indice fuera de rango.");
        }
    }

    public E remove(E e) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(e)) {
                E element = array[i];
                int moveCount = size - i - 1;
                if (moveCount > 0) {
                    System.arraycopy(array, i + 1, array, i, moveCount);
                }
                array[--size] = null;
                return element;
            }
        }
        return null;
    }

    public E remove(int p) throws IndexOutOfBoundsException {
        if (p >= 0 && p < size) {
            E element = array[p];
            int moveCount = size - p - 1;
            if (moveCount > 0) {
                System.arraycopy(array, p + 1, array, p, moveCount);
            }
            array[--size] = null;
            return element;
        } else {
            throw new IndexOutOfBoundsException("Indice fuera de rango.");
        }
    }

    @Override
    public String toString() {
        String cadena = "";
        for (E e : array) {
            cadena += e + " ";
        }
        return "Lista = [ " + cadena + "]";
    }

}
