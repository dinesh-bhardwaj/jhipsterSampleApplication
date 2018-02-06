import { BaseEntity } from './../../shared';

export class RNS_SECTOR_MASTER implements BaseEntity {
    constructor(
        public id?: number,
        public rNSCATGCODE?: string,
        public sECTORCODE?: string,
        public sECTORCODEDESC?: string,
        public rNSCATGMASTER?: BaseEntity,
    ) {
    }
}
