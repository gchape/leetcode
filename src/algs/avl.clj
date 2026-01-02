(ns algs.avl
  (:refer-clojure :exclude [find remove])
  (:require [clojure.inspector :as inspector]))

(defn- height [tree]
  (if (nil? tree)
    0
    (inc (max (height (:left tree))
              (height (:right tree))))))

(defn node
  ([key]
   {:key key
    :height 0
    :left nil
    :right nil})
  ([key left right]
   {:key key
    :height (inc (max (height left) (height right)))
    :left left
    :right right}))

(defn- rotate-left [tree]
  (let [r (:right tree)]
    (node
     (:key r)
     (node (:key tree) (:left tree) (:left r))
     (:right r))))

(defn- rotate-right [tree]
  (let [l (:left tree)]
    (node
     (:key l)
     (:left l)
     (node (:key tree) (:right l) (:right tree)))))

(defn- balance [tree]
  (- (height (:right tree))
     (height (:left tree))))

(defn- fix-balance [tree]
  (let [b (balance tree)]
    (cond
      (> b 1)
      (let [r (:right tree)]
        (if (< (balance r) 0)
          ;; Right-Left case
          (rotate-left (node (:key tree) (:left tree) (rotate-right r)))
          ;; Right-Right case
          (rotate-left tree)))

      (< b -1)
      (let [l (:left tree)]
        (if (> (balance l) 0)
          ;; Left-Right case
          (rotate-right (node (:key tree) (rotate-left l) (:right tree)))
          ;; Left-Left case
          (rotate-right tree)))

      :else
      tree)))

(defn- insert- [tree k]
  (cond
    (nil? tree)
    (node k)

    (< k (:key tree))
    (fix-balance (node (:key tree)
                       (insert- (:left tree) k)
                       (:right tree)))

    (> k (:key tree))
    (fix-balance (node (:key tree)
                       (:left tree)
                       (insert- (:right tree) k)))

    :else tree)) ; no duplicates

(defn- leftmost-node [tree]
  (if (:left tree)
    (recur (:left tree))
    tree))

(defn- remove- [tree k]
  (cond
    (nil? tree)
    nil

    (< k (:key tree))
    (fix-balance (node (:key tree)
                       (remove- (:left tree) k)
                       (:right tree)))

    (> k (:key tree))
    (fix-balance (node (:key tree)
                       (:left tree)
                       (remove- (:right tree) k)))

    :else
    ;; node to delete found
    (cond
      ;; no children
      (and (nil? (:left tree)) (nil? (:right tree)))
      nil

      ;; one child
      (nil? (:left tree))
      (:right tree)

      (nil? (:right tree))
      (:left tree)

      ;; two children
      :else
      (let [succ (leftmost-node (:right tree))]
        (fix-balance
         (node (:key succ)
               (:left tree)
               (remove- (:right tree) (:key succ))))))))

(defn find [tree k]
  (cond
    (nil? tree) nil
    (< k (:key tree)) (find (:left tree) k)
    (> k (:key tree)) (find (:right tree) k)
    :else (:key tree)))

(defn insert [tree k]
  (insert- tree k))

(defn remove [tree k]
  (remove- tree k))

(inspector/inspect-tree
 (-> nil
     (insert 10)
     (insert 5)
     (insert 15)
     (insert 3)
     (insert 7)
     (insert 12)
     (insert 18)
     (insert 6)
     (insert 8)
     (remove 15)
     (remove 3)
     (remove 10)))
