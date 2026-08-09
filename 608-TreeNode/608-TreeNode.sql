-- Last updated: 8/9/2026, 10:04:29 AM
WITH tree_root AS (
    SELECT id, 'Root' AS type
    FROM Tree
    WHERE p_id IS NULL
),
tree_leaves AS (
    SELECT id, 'Leaf' AS type
    FROM Tree
    WHERE id NOT IN (
        SELECT p_id
        FROM Tree
        WHERE p_id IS NOT NULL
    )
    AND id != (
        SELECT id
        FROM tree_root
    )
),
tree_inners AS (
    SELECT id, 'Inner' AS type
    FROM Tree
    WHERE id NOT IN (
        SELECT id FROM tree_root
        UNION ALL
        SELECT id FROM tree_leaves
    )
)
SELECT * FROM tree_root
UNION ALL
SELECT * FROM tree_leaves
UNION ALL
SELECT * FROM tree_inners;