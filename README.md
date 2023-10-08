# Описание симуляции
Симуляция имеет в себе частицы и таблицу отношений цветов RGB.
Частицы находятся в 2-х мерном пространстве, имеют ускорение и свой цвет.
Цвет частицы может быть красный `(R)`, зелёный `(G)` или синий `(B)`.
Таблица отношений цветов описывает как будут частицы двигаться относительно других.
|  | R | G | B |
|--|--|--|--|
| **R** | X | X | X |
| **G** | X | X | X |
| **B** | X | X | X |
|--|--|--|--|

Значение X в каждой ячейке находится в диапазоне от -1 до 1.
Например, отношение R к G :
| Отношение R к G | Результат |
|--|--|
| 1 | Красные частицы притягиваются к зелёным |
| 0 | Красные частицы не реагируют на зелёные |
| -1 | Красные частицы отталкиваются от зелёных |
Комбинаций целочисленных отношений цветов равно 3^9 = 19683.

Большинство комбинаций образует некое ядро в центре пространства из 1 или 2 цветов и расходящееся "облако" частиц которое отдаляется от этого ядра. Можно встретить комбинации где один цвет образует рамку вокруг другого цвета, или где образуется несколько ядер.
Также в симуляции есть "трение" которое замедляет все частицы. 
# Реализация
Симуляция имеет 10 констант которые задает пользователь.
Вычисления в симуляции происходят в виде "шагов".
За шаг :

 - Вычисляем силу притяжения для каждой частицы, проходя по списку всех частиц и в зависимости от цвета и расстояния между первой и второй частицей ускоряем первую.
 - После вычислений применяем скорость каждой частицы к её позиции, тем самым двигая её.
 - Замедляем все частицы (делим их скорость на трение)






