-- Create the new sequence
CREATE SEQUENCE flff_version_seq;
--;;

-- Create the new function using the sequence
CREATE OR REPLACE FUNCTION set_flff_version()
RETURNS trigger AS $$
BEGIN
    IF NEW IS DISTINCT FROM OLD THEN
        NEW.flff_v := nextval('flff_version_seq');
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;
--;;
CREATE TABLE flff_changes (
    batch_id UUID NOT NULL
);
--;;
CREATE INDEX idx_flff_changes_batch_id ON flff_changes(batch_id);

