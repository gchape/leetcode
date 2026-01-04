(ns algs.treap
  (:refer-clojure :exclude [find remove]))

(defn- node
  [key]
  {:key key
   :left nil
   :right nil
   :priority (rand)})

(defn- rotate-left [tree]
  (let [r (:right tree)]
    (assoc r :left
           (assoc tree :right
                  (:left r)))))

(defn- rotate-right [tree]
  (let [l (:left tree)]
    (assoc l :right
           (assoc tree :left
                  (:right l)))))

(defn find
  [tree k]
  (cond
    (nil? tree) false
    (< k (:key tree))
    (find (:left tree) k)
    (> k (:key tree))
    (find (:right tree) k)
    :else true))

(defn add
  [tree k]
  (if (nil? tree)
    (node k)
    (cond
      (< k (:key tree))
      (as-> (assoc tree :left (add (:left tree) k)) t
        (if (< (:priority t) (:priority (:left t)))
          (rotate-right t)
          t))
      (> k (:key tree))
      (as-> (assoc tree :right (add (:right tree) k)) t
        (if (< (:priority t) (:priority (:right t)))
          (rotate-left t)
          t))
      :else tree)))

(defn remove
  [tree k]
  (cond
    (nil? tree)
    nil

    (< k (:key tree))
    (assoc tree :left (remove (:left tree) k))

    (> k (:key tree))
    (assoc tree :right (remove (:right tree) k))

    :else
    (cond
      (nil? (:left tree))
      (:right tree)

      (nil? (:right tree))
      (:left tree)

      :else
      (let [l (:left tree)
            r (:right tree)]
        (if (< (:priority l) (:priority r))
          (let [t (rotate-right tree)]
            (assoc t :right (remove (:right t) k)))
          (let [t (rotate-left tree)]
            (assoc t :left (remove (:left t) k))))))))

(find
 (remove
  (add
   (add
    (add nil 1) 2) 5) 2) 5)
