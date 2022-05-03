package PartI.Stacks;

import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * @author : delusidiot
 * @fileName : StackMain
 * @date : 2022-05-03
 */
public class StackMain {
    public static void main(String[] args) {
        StackOfString stack = new StackOfString();
        /**
         * 전체 시간이 신경쓰일때
         */
        ResizingArrayStackOfStrings arrayStackOfStrings = new ResizingArrayStackOfStrings();
        /**
         * 모든 연산이 균일한 성능을 보장해야 한다면
         * ex) packet 처리 경우 Resizing 으로 인해 갑작스럽게 느리져 데이터 일부를 손실해버릴 수 있다.
         */
        LinkedStackOfStrings linkedStackOfStrings = new LinkedStackOfStrings();
    }
}
