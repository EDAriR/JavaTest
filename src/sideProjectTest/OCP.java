package sideProjectTest;

public class OCP {
//
//    有 專案A 專案B
//
//
//    想要的效果
//    設定檔為A 時
//    class work{
//        執行屬於A的特別method
//        xxxA(){
//
//        }
//    }
//
//    設定檔為B 時
//    class work{
//        執行屬於B的特別method
//        xxxB(){
//
//        }
//    }
//
//    class work不改任何東西
//    xxxA() xxxB() 為根據 設定動態載入
//
//    interface project
//    class A 繼承至 project 在 設定檔為專案A時 new project 會得到A
//    class B 繼承至 project 在 設定檔為專案B時 new project 會得到B
//
//    interface project{
//        A methodA();
//        B methodB();
//    }
//
//    class A{
//        A methodA(){
//            return A;
//        }
//        B methodB(){
//            return null;
//        }
//    }
//
//    class B{
//        A methodA(){
//            return null;
//        }
//        B methodB(){
//            return B;
//        }
//    }
//
//    // 設定為 A 專案
//    class work {
//        A == project.methodA();
//        null == project.methodB();
//    }
//
//    // 設定為 B 專案
//    class work {
//        null == project.methodA();
//        B == project.methodB();
//    }
//
//    return null 的方法不應該存在, 加入專案c時 會違反開放封閉原則 一堆沒做事的method 很礙眼
//
//    interface project{
//        isA();
//    }
//
//    class A{
//        isA(){
//            return true;
//        }
//    }
//
//    class B{
//        isA(){
//            return false;
//        }
//    }
//
//    // 設定為 A 專案
//    class work {
//        if(project.isA()){
//            // 做A該做的事
//        }
//    }
//
//    // 設定為 B 專案
//    class work {
//        if(!project.isA()){
//            // 做B該做的事
//        }
//    }
//    一開始被打槍的作法
//
//    class work{
//
//        @設定為專案A才執行
//        method(){
//           return A;
//        }
//    }
//    太髒
//
//    interface project{
//        default A methodA(){
//            return null;
//        }
//        default B methodB(){
//            return null;
//        }
//    }
//
//    class A{
//
//        @Override
//        A methodA(){
//            return A;
//        }
//
//    }
//
//    class B{
//
//        @Override
//        B methodB(){
//            return B;
//        }
//    }
//
//    // 設定為 A 專案
//    class work {
//        A == project.methodA();
//        null == project.methodB();
//    }
//
//    // 設定為 B 專案
//    class work {
//        null == project.methodA();
//        B == project.methodB();
//    }
//
//    偷吃步
}
